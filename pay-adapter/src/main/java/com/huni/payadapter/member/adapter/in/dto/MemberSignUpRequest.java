package com.huni.payadapter.member.adapter.in.dto;

import com.huni.payadapter.member.application.port.in.dto.MemberSignUpCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberSignUpRequest {

    private String name;
    private String email;
    private String password;

    public MemberSignUpRequest(final String name, final String email, final String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public MemberSignUpCommand toCommand() {
        return new MemberSignUpCommand(name, email, password);
    }
}
