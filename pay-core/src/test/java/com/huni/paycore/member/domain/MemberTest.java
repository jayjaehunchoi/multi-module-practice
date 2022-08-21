package com.huni.paycore.member.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import com.huni.paycommon.exception.InvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MemberTest {

    @DisplayName("회원을 생성할 때 ")
    @Nested
    class CreateMemberTest {

        @DisplayName("이름이 적절하지 않으면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {"  ", "aaaaaaaaaaa", ""})
        void createFailedName(String name) {
            assertThatThrownBy(() -> new Member(name, "huni1234@gmail.com", "abcdF1234!"))
                    .isInstanceOf(InvalidException.class)
                    .hasMessage("잘못된 이름입니다.");
        }

        @DisplayName("이메일이 적절하지 않으면 실패한다.")
        @ParameterizedTest
        @ValueSource(strings = {" ", "sffsf@mm", "acbv"})
        void createFailedEmail(String email) {
            assertThatThrownBy(() -> new Member("최재훈", email, "abcdF1234!"))
                    .isInstanceOf(InvalidException.class)
                    .hasMessage("잘못된 메일주소입니다.");
        }
    }
}
