package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTests {
    @DisplayName("단항 사칙연산 계산하기")
    @ParameterizedTest
    @CsvSource(value = { "2 + 3:5", "2 - 3:-1", "2 * 3:6", "2 / 3:0" }, delimiter = ':')
    void calculatorTest(String input, int result) {
        int number = Calculator.calculate(input);

        assertThat(number).isEqualTo(result);
    }
}
