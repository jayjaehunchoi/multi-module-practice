package com.huni.paycore.member.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.huni.paycommon.exception.InvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름이 적절하지 않으면 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "aaaaaaaaaaa", ""})
    void createFailedName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(InvalidException.class)
                .hasMessage("잘못된 이름입니다.");
    }
}
