package com.devchang202.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void add() {
        int a = (int)(Math.random() * 100);
        int b = (int)(Math.random() * 100);
        int result = calculator.add(a, b);
        assertThat(result).isEqualTo(a + b);
    }

    @Test
    void substrate() {
        int a = (int)(Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int result = calculator.substrate(a, b);
        assertThat(result).isEqualTo(a - b);
    }

    @Test
    void divide() {
        int a = 50;
        int b = 2;
        int result = calculator.divide(a, b);
        assertThat(result).isEqualTo(25);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    calculator.divide(a, 0);
                });
    }

    @Test
    void multiply() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int result = calculator.multiply(a, b);
        assertThat(result).isEqualTo(a * b);
    }
}
