package com.example.softengineerwebpr.domain.auth.service;

import com.example.softengineerwebpr.common.service.EmailService;
import com.example.softengineerwebpr.common.util.UserCodeGenerator; // 수정된 UserCodeGenerator 사용
import com.example.softengineerwebpr.domain.auth.dto.SignUpRequestDto;
import com.example.softengineerwebpr.domain.auth.dto.VerificationCodeEntry;
import com.example.softengineerwebpr.domain.auth.entity.UserCredential;
import com.example.softengineerwebpr.domain.auth.repository.UserCredentialRepository;
import com.example.softengineerwebpr.domain.user.entity.User;
import com.example.softengineerwebpr.domain.user.repository.UserRepository;
import com.example.softengineerwebpr.common.exception.BusinessLogicException;
import com.example.softengineerwebpr.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException; // 추가
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final InMemoryVerificationCodeStore codeStore;
    private final UserCodeGenerator userCodeGenerator; // 수정된 UserCodeGenerator 주입

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {
        log.info("회원가입 서비스 시작: loginId={}", signUpRequestDto.getLoginId());

        if (!verifySubmittedCode(signUpRequestDto.getEmail(), signUpRequestDto.getVerificationCode())) {
            log.warn("Email verification failed for email: {}", signUpRequestDto.getEmail());
            throw new BusinessLogicException(ErrorCode.EMAIL_VERIFICATION_FAILED);
        }

        if (!isLoginIdAvailable(signUpRequestDto.getLoginId())) {
            throw new BusinessLogicException(ErrorCode.LOGIN_ID_DUPLICATION);
        }
        // 닉네임 자체의 전역적 중복 검사는 제거 (닉네임#코드 조합으로 유니크 처리)
        // if (!isNicknameAvailable(signUpRequestDto.getNickname())) {
        //     throw new BusinessLogicException(ErrorCode.NICKNAME_DUPLICATION);
        // }
        if (userRepository.existsByEmail(signUpRequestDto.getEmail())) {
            log.warn("Email already exists: {}", signUpRequestDto.getEmail());
            throw new BusinessLogicException(ErrorCode.EMAIL_DUPLICATION);
        }

        User newUser = User.builder()
                .nickname(signUpRequestDto.getNickname())
                .email(signUpRequestDto.getEmail())
                .isOnline(false)
                .build();

        User savedUser = null;
        int maxAttempts = 10; // 최대 재시도 횟수
        for (int i = 0; i < maxAttempts; i++) {
            String identificationCode = userCodeGenerator.generateRandomFourDigitCode(); // DB 조회 없는 랜덤 코드 생성
            newUser.setIdentificationCode(identificationCode); // User 엔티티에 setter로 설정

            try {
                savedUser = userRepository.saveAndFlush(newUser); // 즉시 DB 반영 및 예외 확인
                log.info("신규 사용자 저장 완료: userId={}, nickname={}, identificationCode={}",
                        savedUser.getIdx(), savedUser.getNickname(), savedUser.getIdentificationCode());
                break; // 저장 성공 시 루프 종료
            } catch (DataIntegrityViolationException e) {
                log.warn("DataIntegrityViolationException for nickname {} with code {}. Attempt {}/{}. Retrying...",
                        newUser.getNickname(), identificationCode, i + 1, maxAttempts);
                if (i == maxAttempts - 1) { // 마지막 시도도 실패한 경우
                    throw new BusinessLogicException(ErrorCode.USER_REGISTRATION_FAILED,
                            "사용자 등록 중 내부 오류 발생 (식별 코드 할당 문제)");
                }
                // 만약 saveAndFlush 후 newUser의 ID가 생성되었다면, 다음 시도를 위해 ID를 null로 초기화하거나
                // 새로운 User 객체를 만들어야 할 수 있습니다. (JPA 구현체에 따라 동작이 다를 수 있음)
                // 여기서는 newUser가 ID가 없는 상태로 재시도된다고 가정, 또는 newUser.idx = null; 과 같은 처리 필요.
                // 더 안전한 방법은 예외 발생 시 newUser 객체를 다시 빌드하는 것입니다. (단, 필수값 누락 주의)
                newUser = User.builder() // 예외 발생 시 객체 상태를 초기화하고 다시 시도하기 위함 (idx가 없는 상태)
                        .nickname(signUpRequestDto.getNickname())
                        .email(signUpRequestDto.getEmail())
                        .isOnline(false)
                        .build();
            }
        }
        if (savedUser == null) { // 모든 시도 실패
            throw new BusinessLogicException(ErrorCode.USER_REGISTRATION_FAILED, "사용자 등록에 최종 실패했습니다.");
        }


        UserCredential newUserCredential = UserCredential.builder()
                .user(savedUser) // 저장 성공한 User 객체 사용
                .loginId(signUpRequestDto.getLoginId())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .build();
        userCredentialRepository.save(newUserCredential);
        log.info("사용자 자격 증명 저장 완료: user_idx={}", savedUser.getIdx());

        codeStore.removeCode(signUpRequestDto.getEmail());
        log.info("회원가입 성공 및 이메일 인증 코드 삭제: loginId={}", signUpRequestDto.getLoginId());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isLoginIdAvailable(String loginId) {
        return !userCredentialRepository.existsByLoginId(loginId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isNicknameAvailable(String nickname) {
        // 닉네임 자체의 중복은 허용되므로, 이 메소드는 유효성 검사(길이, 금칙어 등) 또는 다른 용도로 사용되거나,
        // (닉네임+코드) 조합의 사용 가능성을 체크하는 다른 메소드가 필요할 수 있습니다.
        // 현재는 단순히 true를 반환하거나, 기본적인 유효성 검사만 수행하도록 변경할 수 있습니다.
        // 예: return nickname != null && nickname.length() >= 2 && nickname.length() <= 20; // 단순 길이 체크
        return true; // 닉네임 중복 허용 정책에 따라 수정
    }

    @Override
    public void sendVerificationEmail(String email) {
        if (userRepository.existsByEmail(email)) { // 이미 가입된 이메일인지 체크
            throw new BusinessLogicException(ErrorCode.EMAIL_DUPLICATION, "이미 가입된 이메일입니다. 다른 이메일을 사용해주세요.");
        }
        String verificationCode = userCodeGenerator.generateNumericVerificationCode(4);
        codeStore.storeCode(email, verificationCode);

        String subject = "[팀 프로젝트 관리 웹앱] 이메일 인증번호 안내";
        String text = "회원가입을 위한 인증번호는 [" + verificationCode + "] 입니다. 3분 내에 입력해주세요.";
        try {
            emailService.sendSimpleMessage(email, subject, text);
            log.info("Verification code {} sent to email: {}", verificationCode, email);
        } catch (Exception e) {
            log.error("Failed to send verification email to {}: {}", email, e.getMessage());
            throw new BusinessLogicException(ErrorCode.EMAIL_SEND_FAILED);
        }
    }

    @Override
    public boolean verifySubmittedCode(String email, String submittedCode) {
        VerificationCodeEntry entry = codeStore.getCode(email);
        if (entry == null) {
            log.warn("No verification code found for email: {}", email);
            return false;
        }
        if (entry.isExpired()) {
            log.warn("Verification code expired for email: {}", email);
            codeStore.removeCode(email);
            return false;
        }
        if (entry.getCode().equals(submittedCode)) {
            log.info("Email code verified for email: {}", email);
            return true;
        }
        log.warn("Invalid verification code for email: {}. Submitted: {}, Expected: {}", email, submittedCode, entry.getCode());
        return false;
    }

    @Override
    public void findLoginIdAndSendEmail(String email) {
        log.info("아이디 찾기 서비스 시작: email={}", email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("아이디 찾기: 해당 이메일로 가입된 사용자를 찾을 수 없습니다. email={}", email);
                    // 사용자에게는 "가입되지 않은 이메일"이라고 직접 알리기보다는, "정보를 발송했다"고 일관되게 응답하는 것이
                    // 이메일 존재 유무를 공격자가 알 수 없게 하는 더 안전한 방법일 수 있습니다.
                    // 여기서는 일단 가입된 사용자가 없으면 아무 작업도 하지 않고 성공처럼 응답합니다. (실제로는 이메일 발송 안 됨)
                    // 또는, 명시적으로 에러를 던지고 싶다면 ErrorCode.EMAIL_NOT_FOUND 등을 사용할 수 있습니다.
                    // 요구사항이 "이메일로 아이디 전송"이므로, 가입된 사용자가 없으면 이메일이 안 갈 뿐입니다.
                    // 아래 userCredential 조회에서 어차피 걸러집니다.
                    return new BusinessLogicException(ErrorCode.USER_NOT_FOUND, "해당 이메일로 가입된 사용자 정보를 찾을 수 없습니다.");
                });

        // 해당 User가 일반 가입자인지 확인 (UserCredential이 있는지 여부로 판단)
        UserCredential userCredential = userCredentialRepository.findByUser(user)
                .orElse(null); // 소셜 사용자는 UserCredential이 없을 수 있음

        if (userCredential == null) {
            // 요구사항: "소셜 로그인 연동은 기능 미지원"
            log.warn("아이디 찾기: 소셜 로그인 사용자(email={})는 아이디 찾기를 지원하지 않습니다.", email);
            // 이 경우, 사용자에게 "소셜 로그인 사용자는 이 기능을 사용할 수 없습니다." 와 같은 안내 메일을 보내거나,
            // 혹은 아무 작업도 하지 않고 성공처럼 응답할 수 있습니다.
            // 여기서는 아무 작업도 하지 않고, 컨트롤러에서는 성공 메시지를 보냅니다.
            // (실제로는 이메일 발송 안 됨)
            return;
        }

        String loginId = userCredential.getLoginId();

        // 이메일 발송
        String subject = "[팀 프로젝트 관리 웹앱] 아이디 찾기 결과 안내";
        String text = "요청하신 아이디는 [" + loginId + "] 입니다.";
        try {
            emailService.sendSimpleMessage(email, subject, text);
            log.info("아이디 찾기: {} 이메일로 아이디 {} 발송 완료", email, loginId);
        } catch (Exception e) {
            log.error("아이디 찾기 이메일 발송 실패: email={}, error={}", email, e.getMessage());
            // 이메일 발송 실패는 사용자에게 직접 알리지 않고 내부 로깅만 할 수도 있습니다.
            // 또는 BusinessLogicException(ErrorCode.EMAIL_SEND_FAILED)를 던질 수 있습니다.
            // 여기서는 일단 로깅만 합니다. 컨트롤러는 여전히 성공 메시지를 보냅니다.
        }
    }

    @Override
    public void resetPasswordAndSendEmail(String loginId, String email) {
        log.info("비밀번호 재설정 서비스 시작: loginId={}", loginId);

        UserCredential userCredential = userCredentialRepository.findByLoginId(loginId)
                .orElseThrow(() -> {
                    log.warn("비밀번호 재설정: 해당 아이디를 찾을 수 없습니다. loginId={}", loginId);
                    // 사용자에게는 ID/이메일 불일치 또는 존재하지 않는 계정으로 일관되게 응답하는 것이 좋습니다.
                    return new BusinessLogicException(ErrorCode.USER_INFO_MISMATCH); // ErrorCode에 추가 필요
                });

        User user = userCredential.getUser();
        if (user == null) { // 혹시 모를 데이터 불일치 상황
            log.error("비밀번호 재설정: UserCredential에 연결된 User 객체가 null입니다. loginId={}", loginId);
            throw new BusinessLogicException(ErrorCode.INTERNAL_SERVER_ERROR, "사용자 정보 처리 중 오류가 발생했습니다.");
        }

        // 입력된 이메일과 사용자의 실제 이메일이 일치하는지 확인
        if (!email.equals(user.getEmail())) {
            log.warn("비밀번호 재설정: 아이디 {}에 대해 이메일 정보가 일치하지 않습니다. 입력된 이메일: {}", loginId, email);
            throw new BusinessLogicException(ErrorCode.USER_INFO_MISMATCH); // ErrorCode에 추가 필요
        }

        // (선택적) 소셜 로그인 사용자인 경우 비밀번호 재설정 방지 로직 추가 가능
        // if (!"GENERAL".equals(user.getAuthProvider())) { // User 엔티티에 authProvider 필드가 있다면
        //     log.warn("비밀번호 재설정: 소셜 로그인 사용자({})는 이 기능을 사용할 수 없습니다.", loginId);
        //     throw new BusinessLogicException(ErrorCode.PASSWORD_RESET_NOT_SUPPORTED_FOR_SOCIAL); // ErrorCode에 추가 필요
        // }

        String temporaryPassword = userCodeGenerator.generateRandomTemporaryPassword(10); // 10자리 임시 비밀번호 생성
        userCredential.updatePassword(passwordEncoder.encode(temporaryPassword)); // UserCredential 엔티티에 updatePassword 메소드 필요
        userCredentialRepository.save(userCredential);
        log.info("임시 비밀번호로 업데이트 완료: loginId={}", loginId);

        // 이메일 발송
        String subject = "[팀 프로젝트 관리 웹앱] 임시 비밀번호 안내";
        String text = "회원님의 임시 비밀번호는 [" + temporaryPassword + "] 입니다. \n로그인 후 반드시 비밀번호를 변경해주세요.";
        try {
            emailService.sendSimpleMessage(email, subject, text);
            log.info("비밀번호 재설정: {} 이메일로 임시 비밀번호 발송 완료", email);
        } catch (Exception e) {
            log.error("비밀번호 재설정 이메일 발송 실패: email={}, error={}", email, e.getMessage());
            // DB는 이미 변경되었으므로, 이메일 발송 실패가 치명적일 수 있습니다.
            // 재시도 로직 또는 별도 알림 방안을 고려하거나, 최소한 관리자가 알 수 있도록 심각한 로깅 필요.
            // 여기서는 일단 BusinessLogicException을 던져서 트랜잭션 롤백을 유도할 수 있습니다. (또는 그대로 두고 로깅만)
            throw new BusinessLogicException(ErrorCode.EMAIL_SEND_FAILED, "임시 비밀번호 발송에 실패했습니다. 관리자에게 문의해주세요.");
        }
    }
}