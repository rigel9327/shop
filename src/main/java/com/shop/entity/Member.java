package com.shop.entity;

import com.constant.Role;
import com.shop.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member extends BaseEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

//    public Member() {
//    }
//
//    public Member(String name, String email, String password, String address, Role role) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.role = role;
//    }
//
//    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
//        String password = passwordEncoder.encode(memberFormDto.getPassword());
//        return new Member(memberFormDto.getName(), memberFormDto.getEmail(), password, memberFormDto.getAddress(), Role.USER);
//    }

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {

        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }


}
