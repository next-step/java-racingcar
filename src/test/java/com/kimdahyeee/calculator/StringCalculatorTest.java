package com.kimdahyeee.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("단일 연산자를 이용한 연산")
    @ParameterizedTest(name = "[{displayName}] {0} = {1}")
    @CsvSource({"'5 + 5', 10", "'5 - 5', 0", "'1 * 3', 3", "'4 / 2', 2"})
    void singleOperator(String expression, Integer expected) {
        assertEquals(expected, calculator.calculate(expression));
    }

    @DisplayName("사칙 연산을 모두 포함한 연산")
    @ParameterizedTest(name = "[{displayName}] {0} = {1}")
    @CsvSource({"'2 + 3 * 4 / 2', 10", "'4 + 3 * 2 / 1', 14"})
    void multiOperator(String expression, Integer expected) {
        assertEquals(expected, calculator.calculate(expression));
    }

    @DisplayName("0으로 나누는 경우 ArithmeticException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @ValueSource(strings = {"1 / 0", "2 * 3 / 0"})
    void divide(String expression) {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(expression),
                "0으로 나누기를 할 수 없습니다.");
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값 : \"{0}\"")
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "     "})
    void nullAndEmptyException(String expression) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }

    @DisplayName("연산자가 아닌(없는) 경우 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @ValueSource(strings = {"1 & 1", "^^", "1   2"})
    void notOperator(String expression) {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }
}
