package com.huni.paycore.member.domain;

import com.huni.paycommon.exception.InvalidException;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    private static final String PATTERN = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z.]{2,5}$";

    @Column(name = "email")
    private String value;

    public Email(final String value) {
        validatePattern(value);
        this.value = value;
    }

    private void validatePattern(final String value) {
        if (!value.matches(PATTERN)) {
            throw new InvalidException("잘못된 메일주소입니다.");
        }
    }
}
