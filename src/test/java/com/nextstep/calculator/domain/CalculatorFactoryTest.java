package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.EmptyFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorFactoryTest {
    @DisplayName("문자열 수식을 인자로 Calculator 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String formula = "1 + 2 - 3";

        assertThat(CalculatorFactory.of(formula)).isInstanceOf(Calculator.class);
    }

    @DisplayName("잘못된 문자열 수식으로 Calculator 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "    "})
    void createFailTest(String invalidFormula) {
        assertThatThrownBy(() -> CalculatorFactory.of(invalidFormula)).isInstanceOf(EmptyFormulaException.class);
    }
}