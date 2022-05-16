package com.woojoo.market.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;

    private String email;

    private String name;

    @Embedded
    private Address address;

    @CreatedDate
    private LocalDate createdDate;

    public Member(String loginId, String password, String email, String name, Address address, LocalDate createdDate) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.createdDate = createdDate;
    }
}
