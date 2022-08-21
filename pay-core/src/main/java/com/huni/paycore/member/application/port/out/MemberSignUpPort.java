package com.huni.paycore.member.application.port.out;

import com.huni.paycore.member.domain.Member;

public interface MemberSignUpPort {

    void save(Member member);
}
