package com.huni.payapi.member.adapter.out;

import com.huni.paycore.member.application.port.out.MemberSignUpPort;
import com.huni.paycore.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MemberPersistenceAdapter implements MemberSignUpPort {

    private final MemberRepository memberRepository;

    @Override
    public void save(final Member member) {
        memberRepository.save(member);
    }
}
