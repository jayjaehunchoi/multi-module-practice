package com.huni.payadapter.member.adapter.out;

import static com.huni.payadapter.common.member.MemberFixtures.EMAIL;
import static com.huni.payadapter.common.member.MemberFixtures.NAME;
import static com.huni.payadapter.common.member.MemberFixtures.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.huni.payadapter.common.annotations.AdapterOutTest;
import com.huni.paycore.member.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@AdapterOutTest
class MemberPersistenceAdapterTest {

    private MemberPersistenceAdapter memberPersistenceAdapter;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberPersistenceAdapter = new MemberPersistenceAdapter(memberRepository);
    }

    @DisplayName("멤버를 저장한다.")
    @Test
    void save() {
        Member member = new Member(NAME, EMAIL, PASSWORD);
        assertDoesNotThrow(() -> memberPersistenceAdapter.save(member));
    }
}
