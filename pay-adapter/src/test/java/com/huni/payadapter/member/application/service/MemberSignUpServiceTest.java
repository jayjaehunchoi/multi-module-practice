package com.huni.payadapter.member.application.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import com.huni.payadapter.member.application.port.in.dto.MemberSignUpCommand;
import com.huni.payadapter.member.application.port.out.MemberSignUpPort;
import com.huni.paycore.member.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MemberSignUpServiceTest {

    private MemberSignUpPort memberSignUpPort;
    private MemberSignUpService memberSignUpService;

    @BeforeEach
    void setUp() {
        memberSignUpPort = Mockito.mock(MemberSignUpPort.class);
        memberSignUpService = new MemberSignUpService(memberSignUpPort);
    }

    @DisplayName("회원 가입 시 ")
    @Nested
    class SignUpTest {

        @DisplayName("적절한 요청일 경우 성공한다.")
        @Test
        void signUpSuccess() {
            doNothing().when(memberSignUpPort).save(any(Member.class));
            assertDoesNotThrow(() ->
                    memberSignUpService.signUp(new MemberSignUpCommand("최재훈", "huni1234@gmail.com", "abcdeF1234!")));
        }
    }
}
