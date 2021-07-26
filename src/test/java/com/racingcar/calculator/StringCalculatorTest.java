package com.racingcar.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    public void add() {
        //given
        String given = "5 + 3";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtract() {
        //given
        String given = "5 - 3";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    public void divide() {
        //given
        String given = "21 / 7";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈 테스트")
    public void multiply() {
        //given
        String given = "3 * 7";

        //when
        int result = StringCalculator.calculate(given);

        //then
        assertThat(result).isEqualTo(21);
    }
}
