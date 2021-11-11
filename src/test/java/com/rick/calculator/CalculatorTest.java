package com.rick.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @Test
    @DisplayName("복합 공식 테스트")
    void testFormula() {
        final String input = "2 + 3 * 4 / 2";
        final int expected = 10;
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("잘못된 입력 값(null, empty) 테스트")
    void invalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "%", "@", "#"})
    @DisplayName("지원하지 않는 연산자 사용")
    void unsupportedOperators(String operator) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.validateOperator(operator);
        });
    }
}
