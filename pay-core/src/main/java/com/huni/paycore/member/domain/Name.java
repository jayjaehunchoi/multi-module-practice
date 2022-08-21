package com.huni.paycore.member.domain;

import com.huni.paycommon.exception.InvalidException;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Name {

    private static final int NAME_MAX = 10;
    private static final int NAME_MIN = 0;
    private static final String BLANK = " ";
    private static final String NOT_BLANK = "";

    @Column(name = "name", length = 20)
    private String value;

    public Name(final String value) {
        validateNameLength(value);
        validateNameBlank(value);
        this.value = value.replaceAll(BLANK, NOT_BLANK);
    }

    private void validateNameLength(final String value) {
        if (value.length() > NAME_MAX || value.length() == NAME_MIN) {
            throw new InvalidException("잘못된 이름입니다.");
        }
    }

    private void validateNameBlank(final String value) {
        if (value.isBlank()) {
            throw new InvalidException("잘못된 이름입니다.");
        }
    }
}
