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
    void subtract() {
        assertThat(calculator.subtract(1, 2)).isEqualTo(-1);
        assertThat(calculator.subtract(3, 4)).isEqualTo(-1);
        assertThat(calculator.subtract(100, 200)).isEqualTo(-100);
        assertThat(calculator.subtract(10, 2)).isEqualTo(8);
    }

    @Test
    void multiply() {
        assertThat(calculator.multiply(1, 2)).isEqualTo(2);
        assertThat(calculator.multiply(3, 4)).isEqualTo(12);
        assertThat(calculator.multiply(100, 200)).isEqualTo(20_000);
        assertThat(calculator.multiply(10, 2)).isEqualTo(20);
    }

    @Test
    void divide() {
        assertThat(calculator.divide(2, 2)).isEqualTo(1);
        assertThat(calculator.divide(6, 3)).isEqualTo(2);
        assertThat(calculator.divide(100, 10)).isEqualTo(10);
        assertThat(calculator.divide(50, 2)).isEqualTo(25);
    }
}