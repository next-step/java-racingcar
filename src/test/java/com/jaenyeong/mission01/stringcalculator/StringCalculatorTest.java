package com.jaenyeong.mission01.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("주어진 연산자와 피연산자의 계산을 위한 StringCalculator 클래스 테스트")
class StringCalculatorTest {
    private static final StringParser PARSER = new StringParser();

    @ParameterizedTest
    @MethodSource("validExpression")
    @DisplayName("연산자와 피연산자가 올바른 경우")
    void checkWhenGivenValidExpression(final Expression exp) {
        final StringCalculator sc = new StringCalculator();
        sc.calculateExpression(exp);
    }

    private static Stream<Arguments> validExpression() {
        return Stream.of(
            Arguments.of(PARSER.parseExpression("1 * 2 + 3")),
            Arguments.of(PARSER.parseExpression("3 * 5 + 5 / 4")),
            Arguments.of(PARSER.parseExpression("1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9")),
            Arguments.of(PARSER.parseExpression("-1 * -3 * 7 + 5"))
        );
    }
}
