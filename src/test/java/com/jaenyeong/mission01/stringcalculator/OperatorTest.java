package com.jaenyeong.mission01.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("계산을 담당하는 Operator Enum 테스트")
class OperatorTest {

    @ParameterizedTest
    @MethodSource("validExpression")
    @DisplayName("연산자, 피연산자가 올바른 경우 연산 테스트")
    void calculateExpressionWhenGivenValidExpression(final String operator, final int firstOp, final int secondOp,
                                                     final int correctResult) {

        final int opResult = Operator.calculate(operator, firstOp, secondOp);
        assertEquals(opResult, correctResult);
    }

    private static Stream<Arguments> validExpression() {
        return Stream.of(
            Arguments.of("*", 8, 7, 56),
            Arguments.of("+", 3, 9, 12),
            Arguments.of("/", 10, 5, 2),
            Arguments.of("-", 81, 9, 72)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidExpression")
    @DisplayName("연산자가 올바르지 않은 경우 연산 테스트")
    void calculateExpressionWhenGivenInvalidExpression(final String operator, final int firstOp, final int secondOp,
                                                     final int correctResult) {

        assertThatThrownBy(() -> {
            final int opResult = Operator.calculate(operator, firstOp, secondOp);
            assertEquals(opResult, correctResult);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("operator is not valid");
    }

    private static Stream<Arguments> invalidExpression() {
        return Stream.of(
            Arguments.of("", 8, 7, 56),
            Arguments.of("!", 3, 9, 12),
            Arguments.of(")", 10, 5, 2),
            Arguments.of("[", 81, 9, 72),
            Arguments.of("@", 1, 2, 3),
            Arguments.of("#", 81, 9, 72)
        );
    }
}
