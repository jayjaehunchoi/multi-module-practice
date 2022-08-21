package com.huni.payadapter.member.application.service;

import static com.huni.payadapter.common.member.MemberFixtures.EMAIL;
import static com.huni.payadapter.common.member.MemberFixtures.NAME;
import static com.huni.payadapter.common.member.MemberFixtures.PASSWORD;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

import com.huni.payadapter.member.application.port.in.dto.MemberSignUpCommand;
import com.huni.payadapter.member.application.port.out.MemberQueryPort;
import com.huni.payadapter.member.application.port.out.MemberSignUpPort;
import com.huni.paycore.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

class MemberSignUpServiceTest {

    private MemberSignUpPort memberSignUpPort;
    private MemberQueryPort memberQueryPort;
    private MemberSignUpService memberSignUpService;

    @BeforeEach
    void setUp() {
        memberSignUpPort = Mockito.mock(MemberSignUpPort.class);
        memberQueryPort = Mockito.mock(MemberQueryPort.class);
        memberSignUpService = new MemberSignUpService(memberSignUpPort, memberQueryPort);
    }

    @DisplayName("회원 가입 시 ")
    @Nested
    class SignUpTest {

        @BeforeEach
        void save() {
            doNothing().when(memberSignUpPort).save(any(Member.class));
        }

        @DisplayName("적절한 요청일 경우 성공한다.")
        @Test
        void signUpSuccess() {
            assertDoesNotThrow(() ->
                    memberSignUpService.signUp(new MemberSignUpCommand(NAME, EMAIL, PASSWORD)));
        }

        @DisplayName("동일한 이메일이 존재할 경우 실패한다.")
        @Test
        void signUpEmailFailed() {
            BDDMockito.given(memberQueryPort.existMemberEmail(anyString())).willReturn(true);
            assertThatThrownBy(() -> memberSignUpService.signUp(new MemberSignUpCommand(NAME, EMAIL, PASSWORD)));
        }
    }
}
