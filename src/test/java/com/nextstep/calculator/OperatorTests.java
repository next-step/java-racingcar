package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTests {
    @DisplayName("Operator PLUS로 Number 객체 두개의 덧셈을 수행")
    @Test
    void plusOperatorTest() {
        Number one = Number.stringToNumber("1");
        Operator plus = Operator.PLUS;

        assertThat(plus.operate(one, one)).isEqualTo(Number.stringToNumber("2"));
    }

    @DisplayName("Operator MINUS로 Number 객체 두개의 뺄셈을 수행")
    @Test
    void minusOperatorTest() {
        Number one = Number.stringToNumber("1");
        Operator minus = Operator.MINUS;

        assertThat(minus.operate(one, one)).isEqualTo(Number.stringToNumber("0"));
    }

    @DisplayName("Operator MULTIPLY로 Number 객체 두개의 곱셈을 수행")
    @Test
    void multiplyOperatorTest() {
        Number two = Number.stringToNumber("2");
        Operator multiply = Operator.MULTIPLY;

        assertThat(multiply.operate(two, two)).isEqualTo(Number.stringToNumber("4"));
    }

    @DisplayName("Operator DIVIDE로 Number 객체 두개의 나눗셈을 수행")
    @Test
    void divideOperatorTest() {
        Number four = Number.stringToNumber("4");
        Number two = Number.stringToNumber("2");
        Operator divide = Operator.DIVIDE;

        assertThat(divide.operate(four, two)).isEqualTo(two);
    }

    @DisplayName("Operator DIVIDE에서 0으로 나눌 경우 에러 발생")
    @Test
    void divideOperatorByZeroTest() {
        Number four = Number.stringToNumber("4");
        Number zero = Number.stringToNumber("0");
        Operator divide = Operator.DIVIDE;

        assertThatThrownBy(() -> divide.operate(four, zero)).isInstanceOf(ArithmeticException.class);
    }
}
