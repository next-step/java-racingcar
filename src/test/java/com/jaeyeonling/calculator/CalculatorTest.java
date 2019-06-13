package com.jaeyeonling.calculator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void add() {
        final Calculator calculator = new Calculator();

        assertThat(calculator.add(1, 2)).isEqualTo(3);
        assertThat(calculator.add(3, 4)).isEqualTo(7);
        assertThat(calculator.add(100, 200)).isEqualTo(300);
    }

    @Test
    void minus() {
        final Calculator calculator = new Calculator();

        assertThat(calculator.minus(1, 2)).isEqualTo(-1);
        assertThat(calculator.minus(3, 4)).isEqualTo(-1);
        assertThat(calculator.minus(100, 200)).isEqualTo(-100);
        assertThat(calculator.minus(10, 2)).isEqualTo(8);
    }
}