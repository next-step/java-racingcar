package com.jaeyeonling.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        assertThat(calculator.add(1, 2)).isEqualTo(3);
        assertThat(calculator.add(3, 4)).isEqualTo(7);
        assertThat(calculator.add(100, 200)).isEqualTo(300);
    }

    @Test
    void minus() {
        assertThat(calculator.minus(1, 2)).isEqualTo(-1);
        assertThat(calculator.minus(3, 4)).isEqualTo(-1);
        assertThat(calculator.minus(100, 200)).isEqualTo(-100);
        assertThat(calculator.minus(10, 2)).isEqualTo(8);
    }

    @Test
    void multiply() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
        assertThat(calculator.multiply(3, 4)).isEqualTo(12);
        assertThat(calculator.multiply(100, 200)).isEqualTo(20_000);
        assertThat(calculator.multiply(10, 2)).isEqualTo(20);
    }
}