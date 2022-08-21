package com.huni.payadapter.member.adapter.out;

import static com.huni.payadapter.common.member.MemberFixtures.EMAIL;
import static com.huni.payadapter.common.member.MemberFixtures.NAME;
import static com.huni.payadapter.common.member.MemberFixtures.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;

import com.huni.payadapter.common.annotations.AdapterOutTest;
import com.huni.paycore.member.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@AdapterOutTest
class MemberQueryAdapterTest {

    private MemberQueryAdapter memberQueryAdapter;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberQueryAdapter = new MemberQueryAdapter(memberRepository);
    }

    @DisplayName("id로 멤버를 조회한다.")
    @Test
    void findById() {
        Member member = new Member(NAME, EMAIL, PASSWORD);
        memberRepository.save(member);
        assertThat(memberQueryAdapter.findMemberById(member.getId()).get()).isEqualTo(member);
    }

    @DisplayName("동일한 Email이 존재하는지 확인한다.")
    @Test
    void existsByEmail() {
        Member member = new Member(NAME, EMAIL, PASSWORD);
        memberRepository.save(member);
        assertThat(memberQueryAdapter.existMemberEmail(EMAIL)).isTrue();
    }
}
