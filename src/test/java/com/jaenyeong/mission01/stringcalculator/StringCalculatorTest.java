package com.jaenyeong.mission01.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("주어진 연산자와 피연산자의 계산을 위한 StringCalculator 클래스 테스트")
class StringCalculatorTest {

    @ParameterizedTest
    @MethodSource("validExpressionWhenCreateCalculator")
    @DisplayName("연산자와 피연산자가 올바른 경우 Calculator 객체 생성 테스트")
    void createCalculatorInstanceWhenGivenValidExpression(final List<String> operators, final List<Integer> operands) {
        final StringCalculator sc = new StringCalculator(operators, operands);
    }

    private static Stream<Arguments> validExpressionWhenCreateCalculator() {
        return Stream.of(
            // 1 * 2 + 3
            Arguments.of(Arrays.asList("*", "+"), Arrays.asList(1, 2, 3)),
            // 3 * 5 + 5 / 4
            Arguments.of(Arrays.asList("*", "+", "/"), Arrays.asList(3, 5, 5, 4)),
            // 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9
            Arguments.of(Arrays.asList("+", "+", "+", "+", "+", "+", "+", "+"),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            // -1 * -3 * 7 + 5
            Arguments.of(Arrays.asList("*", "*", "+"), Arrays.asList(-1, -3, 7, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidExpressionWhenCreateCalculator")
    @DisplayName("연산자, 피연산자가 올바르지 않은 경우 Calculator 객체 생성 테스트")
    void createCalculatorInstanceWhenGivenInvalidExpression(final List<String> operators, final List<Integer> operands) {
        assertThatThrownBy(() -> {
            final StringCalculator sc = new StringCalculator(operators, operands);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("operator or operand is not valid");
    }

    private static Stream<Arguments> invalidExpressionWhenCreateCalculator() {
        return Stream.of(
            // 1 2 3
            Arguments.of(Arrays.asList(""), Arrays.asList(1, 2, 3)),
            // 1 * 2 3
            Arguments.of(Arrays.asList("*"), Arrays.asList(1, 2, 3)),
            // 1 + 2 + +
            Arguments.of(Arrays.asList("+", "+", "+"),
                Arrays.asList(1, 2)),
            // 3 3 3 / 4
            Arguments.of(Arrays.asList("/"), Arrays.asList(3, 3, 3, 4))
        );
    }
}
