package com.jaenyeong.mission01.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("연산자와 비연산자를 담는 수식 Expression 클래스 테스트")
class ExpressionTest {

    @ParameterizedTest
    @MethodSource("validExpression")
    @DisplayName("연산자와 피연산자가 올바른 경우")
    void checkWhenGivenValidExpression(final List<Operator> operators, final List<Integer> operands) {
        Expression exp = new Expression(operators, operands);
    }

    private static Stream<Arguments> validExpression() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("*"),
                    Operator.getOperator("+")
                ),
                Arrays.asList(1, 2, 3)),
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("*"),
                    Operator.getOperator("+"),
                    Operator.getOperator("/")
                ),
                Arrays.asList(3, 5, 5, 4)),
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("+"),
                    Operator.getOperator("+"),
                    Operator.getOperator("+"),
                    Operator.getOperator("+"),
                    Operator.getOperator("+"),
                    Operator.getOperator("+"),
                    Operator.getOperator("+"),
                    Operator.getOperator("+")
                ),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("*"),
                    Operator.getOperator("*"),
                    Operator.getOperator("+")
                ),
                Arrays.asList(-1, -3, 7, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidExpression")
    @DisplayName("연산자와 피연산자가 올바른 경우")
    void checkWhenGivenInvalidExpression(final List<Operator> operators, final List<Integer> operands) {
        assertThatThrownBy(() -> {
            Expression exp = new Expression(operators, operands);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("operators and operands is not valid");
    }

    private static Stream<Arguments> invalidExpression() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("*"),
                    Operator.getOperator("+"),
                    Operator.getOperator("/")
                ),
                Arrays.asList(1, 2, 3)),
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("*"),
                    Operator.getOperator("+"),
                    Operator.getOperator("/")
                ),
                Arrays.asList(3, 2)),
            Arguments.of(
                Arrays.asList(),
                Arrays.asList()),
            Arguments.of(
                Arrays.asList(
                    Operator.getOperator("*"),
                    Operator.getOperator("*"),
                    Operator.getOperator("+")
                ),
                Arrays.asList(-1, -3, 7))
        );
    }
}
