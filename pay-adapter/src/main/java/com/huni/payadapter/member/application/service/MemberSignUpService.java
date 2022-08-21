package com.huni.payadapter.member.application.service;

import com.huni.payadapter.member.application.port.in.MemberSignUpUseCase;
import com.huni.payadapter.member.application.port.in.dto.MemberSignUpCommand;
import com.huni.payadapter.member.application.port.out.MemberSignUpPort;
import com.huni.paycore.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class MemberSignUpService implements MemberSignUpUseCase {

    private final MemberSignUpPort memberSignUpPort;

    @Override
    public void signUp(final MemberSignUpCommand memberSignUpCommand) {
        Member member = memberSignUpCommand.toEntity();
        memberSignUpPort.save(member);
    }
}
