package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        assertThat(calculator.calculate("1 - 1")).isEqualTo(0);
        assertThat(calculator.calculate("10 - 2")).isEqualTo(8);
        assertThat(calculator.calculate("500 - 2")).isEqualTo(498);
    }

    @Test
    void multiply() {
        assertThat(calculator.calculate("1 * 1")).isEqualTo(1);
        assertThat(calculator.calculate("10 * 2")).isEqualTo(20);
        assertThat(calculator.calculate("500 * 2")).isEqualTo(1000);
    }

    @Test
    void divide() {
        assertThat(calculator.calculate("1 / 1")).isEqualTo(1);
        assertThat(calculator.calculate("10 / 2")).isEqualTo(5);
        assertThat(calculator.calculate("500 / 2")).isEqualTo(250);
    }

    @Test
    void complexCalculate() {
        assertThat(calculator.calculate("1 + 1 + 1 + 123")).isEqualTo(126);
        assertThat(calculator.calculate("1 - 1 + 1 * 100")).isEqualTo(100);
        assertThat(calculator.calculate("1 * 2 * 3 * 4 * 5")).isEqualTo(120);
        assertThat(calculator.calculate("100 / 2 * 2 + 100 - 50")).isEqualTo(150);
    }

    @Test
    void invalidInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(null);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("");
                });
    }


    @Test
    void invalidOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("1 & 1");
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("1 ( 1");
                });
    }

}