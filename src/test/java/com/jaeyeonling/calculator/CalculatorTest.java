package com.jaeyeonling.calculator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void add() {
        final Calculator calculator = new Calculator();

        final int result = calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }
}