package com.string.calculator;

import com.string.calculator.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @DisplayName("문자열 사칙 연산 계산기 구현")
    @ParameterizedTest
    @MethodSource("provideCalculations")
    void calculatorTest(String calculation, Double expected) {
        Calculator calculator = new Calculator(calculation);
        assertEquals(calculator.evaluate(), expected);
    }

    private static Stream<Arguments> provideCalculations() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", 10.0),
                Arguments.of("2 + 3", 5.0),
                Arguments.of("2 + 7 / 5", 1.8)
        );
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void calculatorTest(String calculation) {
        assertThatThrownBy(() -> new Calculator(calculation)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우")
    @ParameterizedTest
    @MethodSource("provideInvalidCalculations")
    void invalidCalculationTest(String invalidCalculation) {
        assertThatThrownBy(() -> {
            Calculator calculator = new Calculator(invalidCalculation);
            calculator.evaluate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidCalculations() {
        return Stream.of(
                Arguments.of("2 + 3 & 4 / 2"),
                Arguments.of("2 # 3"),
                Arguments.of("2 ! 7 = 5")
        );
    }
}
