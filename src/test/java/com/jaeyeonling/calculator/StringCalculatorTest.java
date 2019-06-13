package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void add() {
        assertThat(calculator.calculate("1 + 1")).isEqualTo(2);
        assertThat(calculator.calculate("2 + 5")).isEqualTo(7);
        assertThat(calculator.calculate("123 + 123")).isEqualTo(246);
    }

    @Test
    void subtract() {
        assertThat(calculator.calculate("1 - 1")).isEqualTo(1);
        assertThat(calculator.calculate("10 - 2")).isEqualTo(5);
        assertThat(calculator.calculate("500 - 2")).isEqualTo(250);
    }

    @Test
    void multiply() {

    }

    @Test
    void divide() {

    }
}
