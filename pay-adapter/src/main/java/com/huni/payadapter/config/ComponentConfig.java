package com.huni.payadapter.config;

import com.huni.payadapter.member.adapter.out.MemberPersistenceAdapter;
import com.huni.payadapter.member.adapter.out.MemberRepository;
import com.huni.paycore.member.application.port.out.MemberSignUpPort;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ComponentConfig {

    private final MemberRepository memberRepository;

    @ConditionalOnMissingBean(name = "memberSignUpPort")
    public MemberSignUpPort memberSignUpPort() {
        return new MemberPersistenceAdapter(memberRepository);
    }
}
