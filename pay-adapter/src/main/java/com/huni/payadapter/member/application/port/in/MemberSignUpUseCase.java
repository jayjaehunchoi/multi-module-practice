package com.huni.payadapter.member.application.port.in;

import com.huni.payadapter.member.application.port.in.dto.MemberSignUpCommand;

public interface MemberSignUpUseCase {

     void signUp(MemberSignUpCommand memberSignUpCommand);
}
