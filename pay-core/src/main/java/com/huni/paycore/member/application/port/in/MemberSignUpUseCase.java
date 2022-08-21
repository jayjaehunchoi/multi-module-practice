package com.huni.paycore.member.application.port.in;

import com.huni.paycore.member.application.port.in.dto.MemberSignUpCommand;

public interface MemberSignUpUseCase {

     void signUp(MemberSignUpCommand memberSignUpCommand);
}
