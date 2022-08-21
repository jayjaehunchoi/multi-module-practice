package com.huni.payadapter.member.adapter.out;

import com.huni.payadapter.member.application.port.out.MemberQueryPort;
import com.huni.paycore.member.domain.Member;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberQueryAdapter implements MemberQueryPort {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMemberById(final Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public boolean existMemberEmail(final String email) {
        return memberRepository.existsByEmail(email);
    }
}
