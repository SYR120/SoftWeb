package com.example.softengineerwebpr.domain.auth.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "oauth2_providers",
        uniqueConstraints = {// name 컬럼에 대한 unique 제약 조건 설정
            @UniqueConstraint(name = "uk_oauth2_providers_name", columnNames = "name")
        })
public class OAuthProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(nullable = false, length = 50)
    private String name; // 제공자 이름 (예: "naver", "kakao")

    @Column(nullable = false)
    private boolean activation; // 제공자의 활성화 상태 (기본값은 DB 스키마 DEFAULT TRUE 따름)

    @Builder
    public OAuthProvider(String name, boolean activation) {
        this.name = name;
        this.activation = activation;
    }

    // 활성화 상태 변경 메소드 (필요시)
    public void updateActivation(boolean activation) {
        this.activation = activation;
    }
}
