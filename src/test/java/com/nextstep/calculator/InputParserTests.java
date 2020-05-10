package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTests {
    @DisplayName("입력값이 null이나 빈 공백 문자일 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = "   ")
    void inputValidator(String invalidInput) {
        assertThatThrownBy(() -> InputParser.validate(invalidInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값을 공백으로 구분해서 List 반환")
    @Test
    void parse() {
        String validInput = "3 + 2 / 4 * 5";
        List<String> parsed = InputParser.parse(validInput);

        assertThat(parsed).containsExactly("3", "+", "2", "/", "4", "*", "5");
        assertThat(parsed).doesNotContain(" ");
    }
}
