package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.EmptyFormulaException;
import com.nextstep.calculator.domain.exceptions.InvalidCalculatorFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorFactoryTest {
    @DisplayName("문자열 수식을 인자로 Calculator 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        String formula = "1 + 2 - 3";

        assertThat(CalculatorFactory.createCalculator(formula)).isInstanceOf(Calculator.class);
    }

    @DisplayName("빈 문자열 수식으로 Calculator 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "    "})
    void createFailByEmptyFormulaTest(String invalidFormula) {
        assertThatThrownBy(() -> CalculatorFactory.createCalculator(invalidFormula)).isInstanceOf(EmptyFormulaException.class);
    }

    @DisplayName("잘못된 문자열 수식으로 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"3", "3 2", "3 + 2 4", "+ 3 - 2", "3 + 2 -", "+ -"})
    void createFailByTooManyNumbersTest(String invalidFormula) {
        assertThatThrownBy(() -> CalculatorFactory.createCalculator(invalidFormula))
                .isInstanceOf(InvalidCalculatorFormulaException.class);
    }
}
