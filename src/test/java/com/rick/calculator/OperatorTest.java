package com.rick.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
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
}
