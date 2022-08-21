package com.huni.payapi.member.adapter.out;

import com.huni.paycore.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
