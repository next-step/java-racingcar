package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTests {
    @DisplayName("문자열 형태의 int 타입 값을 속성으로 갖는 Number 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"3", "0", "-3"})
    void createNumberFromString(String inputString) {
        Number number = Number.stringToNumber(inputString);

        assertThat(number.value()).isEqualTo(Integer.parseInt(inputString));
    }
}
