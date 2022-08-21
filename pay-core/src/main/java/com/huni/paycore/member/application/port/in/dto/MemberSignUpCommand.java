package com.huni.paycore.member.application.port.in.dto;

import com.huni.paycore.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberSignUpCommand {

    private final String name;
    private final String email;
    private final String password;

    public MemberSignUpCommand(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Member toEntity() {
        return new Member(name, email, password);
    }
}
