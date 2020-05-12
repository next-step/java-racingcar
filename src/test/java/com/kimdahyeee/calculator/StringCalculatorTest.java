package com.kimdahyeee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("문자열 계산기 테스트")
public class StringCalculatorTest {
    @DisplayName("단일 연산자를 이용한 연산")
    @ParameterizedTest(name = "[{displayName}] {0} = {1}")
    @CsvSource({"'5 + 5', 10", "'5 - 5', 0", "'1 * 3', 3", "'4 / 2', 2"})
    void singleOperator(String input, Integer result) {

    }

    @DisplayName("사칙 연산을 모두 포함한 연산")
    @ParameterizedTest(name = "[{displayName}] {0} = {1}")
    @CsvSource({"'2 + 3 * 4 / 2', 10", "'4 + 3 * 2 / 1', 14"})
    void multiOperator(String input, Integer result) {

    }

    @DisplayName("0으로 나누는 경우 ArithmeticException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @ValueSource(strings = {"1 / 0", "2 * 3 / 0"})
    void divide() {

    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @NullAndEmptySource
    void nullAndEmptyException(String input) {

    }

    @DisplayName("연산자가 아닌(없는) 경우 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @ValueSource(strings = {"1 & 1", "^^", "1   2"})
    void notOperator(String input) {

    }
}
