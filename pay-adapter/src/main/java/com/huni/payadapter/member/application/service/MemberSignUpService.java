package com.huni.payadapter.member.application.service;

import com.huni.payadapter.member.application.port.in.MemberSignUpUseCase;
import com.huni.payadapter.member.application.port.in.dto.MemberSignUpCommand;
import com.huni.payadapter.member.application.port.out.MemberQueryPort;
import com.huni.payadapter.member.application.port.out.MemberSignUpPort;
import com.huni.paycommon.exception.InvalidException;
import com.huni.paycore.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
class MemberSignUpService implements MemberSignUpUseCase {

    private final MemberSignUpPort memberSignUpPort;
    private final MemberQueryPort memberQueryPort;

    @Override
    public void signUp(final MemberSignUpCommand memberSignUpCommand) {
        validateSameEmail(memberSignUpCommand);
        Member member = memberSignUpCommand.toEntity();
        memberSignUpPort.save(member);
    }

    private void validateSameEmail(final MemberSignUpCommand memberSignUpCommand) {
        if (memberQueryPort.existMemberEmail(memberSignUpCommand.getEmail())) {
            throw new InvalidException("동일한 이름의 회원이 존재합니다.");
        }
    }
}
