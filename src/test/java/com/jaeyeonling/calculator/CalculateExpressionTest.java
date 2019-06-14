package com.jaeyeonling.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculateExpressionTest {

    @DisplayName("CalculateExpression 생성")
    @Test
    void createCalculateValue() {
        assertThat(expression("1 + 1")).isNotNull();
    }

    @DisplayName("null 계산식 입력 시 예외처리")
    @Test
    void nullExpression() {
        calculateThrowIllegalArgumentExceptionTest(null);
    }

    @DisplayName("빈 값 계산식 입력 시 예외처리")
    @Test
    void emptyExpression() {
        calculateThrowIllegalArgumentExceptionTest("");
    }

    @DisplayName("수식없는 하나의 숫자 계산식 입력 시 예외처리")
    @Test
    void singleExpression() {
        calculateThrowIllegalArgumentExceptionTest("123");
    }

    @DisplayName("갯수가 맞지 않는 계산식 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {
            "123 *",
            "123 * 1 + 5 +",
            "* 1231",
            "123123 *"
    })
    void evenExpression(final String expression) {
        calculateThrowIllegalArgumentExceptionTest(expression);
    }

    @DisplayName("잘못된 수식 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {
            "123 & 124",
            "123 ^ 23423",
            "123 ! 23423",
            "123 +-/* 23423"
    })
    void invalidOperationSymbolExpression(final String expression) {
        calculateThrowIllegalArgumentExceptionTest(expression);
    }

    @DisplayName("더하기")
    @ParameterizedTest
    @CsvSource({
            "1 + 1,2",
            "2 + 5,7",
            "123 + 123,246"
    })
    void add(final String expression, final Integer result) {
        calculateTest(expression, result);
    }

    @DisplayName("빼기")
    @ParameterizedTest
    @CsvSource({
            "1 - 1,0",
            "10 - 2,8",
            "500 - 2,498"
    })
    void subtract(final String expression, final Integer result) {
        calculateTest(expression, result);
    }

    @DisplayName("곱하기")
    @ParameterizedTest
    @CsvSource({
            "1 * 1,1",
            "10 * 2,20",
            "500 * 2,1000"
    })
    void multiply(final String expression, final Integer result) {
        calculateTest(expression, result);
    }

    @DisplayName("나누기")
    @ParameterizedTest
    @CsvSource({
            "1 / 1,1",
            "10 / 2,5",
            "500 / 2,250"
    })
    void divide(final String expression, final Integer result) {
        calculateTest(expression, result);
    }

    @Test
    @DisplayName("0으로 나눌 시 예외처리")
    void divideByZero() {
        calculateThrowExceptionTest("1 / 0", ArithmeticException.class);
    }

    @DisplayName("복합적인 계산")
    @ParameterizedTest
    @CsvSource({
            "1 + 1 + 1 + 123,126",
            "1 - 1 + 1 * 100,100",
            "1 * 2 * 3 * 4 * 5,120",
            "100 / 2 * 2 + 100 - 50,150"
    })
    void complexCalculate(final String expression, final Integer result) {
        calculateTest(expression, result);
    }

    private void calculateThrowIllegalArgumentExceptionTest(final String expression) {
        calculateThrowExceptionTest(expression, IllegalArgumentException.class);
    }

    private void calculateThrowExceptionTest(final String expression,
                                             final Class<? extends Exception> targetException) {
        assertThatExceptionOfType(targetException)
                .isThrownBy(() -> calculate(expression));
    }

    private void calculateTest(final String expression, final Integer result) {
        assertThat(calculate(expression)).isEqualTo(result);
    }

    private int calculate(final String expression) {
        return StringCalculator.calculate(expression(expression));
    }

    private CalculateExpression expression(final String expression) {
        return CalculateExpression.ofExpression(expression);
    }
}
