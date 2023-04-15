package com.next.step.step3.domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @ParameterizedTest(name = "자동차 이름 생성 시 빈 문자열이 존재할 경우")
    @NullAndEmptySource
    void validateCarNameLength_빈_문자열(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 최소 길이는 1글자입니다.");
    }

    @ParameterizedTest(name = "자동차 이름 생성 시 5글자 이상이 존재할 경우")
    @ValueSource(strings = {"abcdef", "ghkdwlgns", "next-step"})
    void validateCarNameLength_5글자_이상_문자열(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름의 최대 길이는 5글자입니다.");
    }
}
