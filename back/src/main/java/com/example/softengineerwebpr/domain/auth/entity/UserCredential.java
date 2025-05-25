package com.example.softengineerwebpr.domain.auth.entity;

import com.example.softengineerwebpr.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_credential",
        uniqueConstraints = { // id 컬럼에 대한 unique 제약 조건 설정
            @UniqueConstraint(name = "uk_user_credentials_id", columnNames = "id")
        })
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx; // 자격 증명의 고유 식별자 (DB 스키마 INT -> Long 매핑)

    // User 엔티티와 1:1 관계 설정 (한 명의 사용자는 하나의 자격 증명 세트를 가짐)
    // User가 삭제되면 UserCredential도 함께 삭제되도록 cascade 설정
    // user_idx 컬럼은 User 엔티티의 기본 키를 참조
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //User 삭제 시 자동 삭제
    @JoinColumn(name = "user_idx", nullable = false, foreignKey = @ForeignKey(name = "fk_user_credentials_user"))
    private User user; // 해당 자격 증명의 사용자

    @Column(name = "id", nullable = false, length = 20) // unique 제약은 @Table에서 설정
    private String loginId; // 사용자 로그인 ID (DB 컬럼명 'id'와 매핑)

    @Column(nullable = false, length = 255) // 비밀번호는 해시되어 저장되므로 길이 충분히
    private String password; // 사용자 비밀번호 (해시된 값)

    @Builder
    public UserCredential(User user, String loginId, String password) {
        this.user = user;
        this.loginId = loginId;
        this.password = password;
    }

    // 비밀번호 변경 메소드 (서비스 계층에서 암호화된 비밀번호를 받아와서 설정)
    public void updatePassword(String newEncodedPassword) {
        this.password = newEncodedPassword;
    }
}

