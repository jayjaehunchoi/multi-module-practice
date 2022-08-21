package com.huni.paycore.member.application.port.out;

import com.huni.paycore.member.domain.Member;
import java.util.Optional;

public interface MemberQueryPort {

    Optional<Member> findMemberById(Long memberId);

    boolean existMemberEmail(String email);
}
