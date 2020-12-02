package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorFactoryTest {
    @DisplayName("문자열 수식을 인자로 Calculator 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String formula = "1 + 2 - 3";

        assertThat(CalculatorFactory.of(formula)).isInstanceOf(Calculator.class);
    }
}