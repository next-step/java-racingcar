package com.racingcar.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void 덧셈() {
        //given
        String given = "5 + 3";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(8);
    }
}
