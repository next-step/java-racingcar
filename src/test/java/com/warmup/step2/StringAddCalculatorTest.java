package com.warmup.step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void isEqualTo_하나의_문자열을_숫자형으로_반환() {
        String numberStr = "1";

        assertThat(StringAddCalculator.splitAndSum(numberStr)).isEqualTo(1);
    }
}