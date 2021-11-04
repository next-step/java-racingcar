package com.kakao.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("calculator를 생성하고 연산을 수행하면 올바른 결과를 낸다.")
    void defaultCalculate() {

        StringCalculator calculator = new StringCalculator();
        double result1 = calculator.calculate("1 + 3");
        double result2 = calculator.calculate("1 * 3");

        assertThat(result1).isEqualTo(4.0);
        assertThat(result2).isEqualTo(3.0);
    }

    @Test
    @DisplayName("delimeter를 지정하여, 여러방식의 계산기를 만들 수 있다.")
    void poundCalculator() {
        StringCalculator calculator = new StringCalculator(":");
        double result1 = calculator.calculate("1:+:3");

        assertThat(result1).isEqualTo(4.0);
    }


}
