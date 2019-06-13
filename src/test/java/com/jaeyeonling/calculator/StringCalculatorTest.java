package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void add() {
        assertThat(calculator.calculate("1 + 1")).isEqualTo(2);
    }

    @Test
    void subtract() {

    }

    @Test
    void multiply() {

    }

    @Test
    void divide() {

    }
}
