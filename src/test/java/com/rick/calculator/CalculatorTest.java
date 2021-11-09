package com.rick.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        final int leftOperand = 5;
        final int rightOperand = 2;
        final int expected = 7;
        assertThat(Operator.ADD.calc(leftOperand, rightOperand)).isEqualTo(expected);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtract() {
        final int leftOperand = 5;
        final int rightOperand = 2;
        final int expected = 3;
        assertThat(Operator.SUBTRACT.calc(leftOperand, rightOperand)).isEqualTo(expected);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        final int leftOperand = 5;
        final int rightOperand = 2;
        final int expected = 10;
        assertThat(Operator.MULTIPLY.calc(leftOperand, rightOperand)).isEqualTo(expected);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        final int leftOperand = 22;
        final int rightOperand = 2;
        final int expected = 11;
        assertThat(Operator.DIVIDE.calc(leftOperand, rightOperand)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("잘못된 입력 값(null, empty) 테스트")
    void invalidInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calc(input);
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
