package com.kkambi.racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    @DisplayName("사칙연산 단일 연산자 테스트")
    @MethodSource("singleOperatorProvider")
    @ParameterizedTest
    void calculateWithSingleOperator(String formula, int expectedResult) {
        // when
        int result = StringCalculator.calculate(formula);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("사칙연산 다수 연산자 테스트")
    @MethodSource("multipleOperatorProvider")
    @ParameterizedTest
    void calculateWithMultipleOperator(String formula, int expectedResult) {
        // when
        int result = StringCalculator.calculate(formula);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("사칙연산 예외 테스트")
    @MethodSource("exceptionProvider")
    @ParameterizedTest
    void throwExceptionWhenEmptyFormula(String formula, String expectedMessage) {
        // when
        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class, () -> StringCalculator.calculate(formula)
        );

        // then
        assertThat(illegalArgumentException).hasMessageContaining(expectedMessage);
    }

    private static Stream<Arguments> singleOperatorProvider() {
        return Stream.of(
                Arguments.of("1 + 124", 125),
                Arguments.of("3 - 44", -41),
                Arguments.of("25 * 3", 75),
                Arguments.of("100 / 25", 4)
        );
    }

    private static Stream<Arguments> multipleOperatorProvider() {
        return Stream.of(
                Arguments.of("1 + 124 - 25 * 11", 1100),
                Arguments.of("2 + 3 * 4 / 2", 10),
                Arguments.of("4 / 2 * 3 + 2", 8)
        );
    }

    private static Stream<Arguments> exceptionProvider() {
        return Stream.of(
                Arguments.of("", "빈 문자열"),
                Arguments.of(" ", "빈 문자열"),
                Arguments.of("10 % 5", "올바른 사칙연산 기호")
        );
    }
}