package com.warmup.step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void isEqualTo_문자열_쉽표로_분리_덧셈하여_반환() {
        String numberStr = "3,6";
        int expectedResult = 9;

        assertThat(StringAddCalculator.splitAndSum(numberStr)).isEqualTo(expectedResult);
    }

    @Test
    public void isEqualTo_빈문자열_0_반환() {
        String numberStr = "";
        int expectedResult = 0;

        assertThat(StringAddCalculator.splitAndSum(numberStr)).isEqualTo(expectedResult);
    }

    @Test
    public void isEqualTo_NULL_0_반환() {
        String numberStr = null;
        int expectedResult = 0;

        assertThat(StringAddCalculator.splitAndSum(numberStr)).isEqualTo(expectedResult);
    }

    @Test
    public void isEqualTo_하나의_문자열을_숫자형으로_반환() {
        String numberStr = "1";
        int expectedResult = 1;

        assertThat(StringAddCalculator.splitAndSum(numberStr)).isEqualTo(expectedResult);
    }
}