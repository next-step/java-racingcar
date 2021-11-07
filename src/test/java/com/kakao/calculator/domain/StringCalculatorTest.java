package com.kakao.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("calculator를 생성하고 연산을 수행하면 올바른 결과를 낸다.")
    @CsvSource(value = {"+:4", "*:3", "-:2", "/:3"}, delimiter = ':')
    void defaultCalculate(String operator, String expected) {

        StringCalculator calculator = new StringCalculator();
        String input = String.format("3 %s 1", operator);
        double result = calculator.calculate(input);

        assertThat(result).isEqualTo(Double.parseDouble(expected));
    }

    @Test
    @DisplayName("delimeter를 지정하여, 여러방식의 계산기를 만들 수 있다.")
    void poundCalculator() {
        StringCalculator calculator = new StringCalculator(":");
        double result1 = calculator.calculate("1:+:3");

        assertThat(result1).isEqualTo(4.0);
    }


}
