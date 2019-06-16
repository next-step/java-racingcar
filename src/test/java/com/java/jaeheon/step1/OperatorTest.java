package com.java.jaeheon.step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void addition() {
        assertThat(Operator.ADDITION.calculator(5, 3)).isEqualTo(5 + 3);
    }

    @Test
    void subtraction() {
        assertThat(Operator.SUBTRACTION.calculator(5, 3)).isEqualTo(5 - 3);
    }

    @Test
    void multiplication() {
        assertThat(Operator.MULTIPLICATION.calculator(5, 3)).isEqualTo(5 * 3);

    }

    @Test
    void division() {
        assertThat(Operator.DIVISION.calculator(5, 3)).isEqualTo(5 / 3);

    }
}
