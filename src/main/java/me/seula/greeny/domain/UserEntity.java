package me.seula.greeny.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*
        사용자명
    */
    @Column(unique = true, nullable = false)
    private String username;

    /*
        비밀번호
    */
    @Column(nullable = false)
    private String password;

    /*
        이름
    */
    @Column(nullable = false)
    private String name;

    /*
        생년월일
    */
    @Column(nullable = false)
    private String birth;

    /*
        총 경험치
    */
    @Column(nullable = false)
    private int totalExp;

    /*
        가진 포인트
    */
    @Column(nullable = false)
    private int hasPoint;

    /*
        권한 정보 (임시)
    */
    @Column(nullable = false)
    private String role;

    @Builder
    public UserEntity(
            String username,
            String password,
            String name,
            String birth,
            int totalExp,
            int hasPoint,
            String role)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.totalExp = totalExp;
        this.hasPoint = hasPoint;
        this.role = role;
    }
}
