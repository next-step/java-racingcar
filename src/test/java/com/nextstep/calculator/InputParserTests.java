package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTests {
    @DisplayName("입력값이 null이나 빈 공백 문자일 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "   ")
    void inputValidator(String invalidInput) {
        assertThatThrownBy(() -> InputParser.validate(invalidInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
