package com.kimdahyeee.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Operator 객체 단위 테스트")
class OperatorTest {
    @DisplayName("사칙 연산")
    @ParameterizedTest(name = "{displayName} {0} {1} {2} = {3}")
    @CsvSource({"1, +, 2, 3", "2, -, 1, -1", "3, *, 4, 12", "2, /, 100, 50"})
    void successCase(Integer untilVal, String sign, Integer newVal, Integer expected) {
        assertEquals(expected, Operator.operation(sign, untilVal, newVal));
    }

    @DisplayName("0으로 나누는 경우 ArithmeticException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @CsvSource({"1, /, 0"})
    void divideExceptionCase(Integer untilVal, String sign, Integer newVal) {
        assertThrows(ArithmeticException.class,
                () -> Operator.operation(sign, newVal, untilVal),
                "0으로 나누기를 할 수 없습니다.");
    }

    @DisplayName("연산자가 아닌(없는) 경우 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest(name = "[{displayName}] 입력 값: {0}")
    @CsvSource({"1, &, 0"})
    void doNotOperate(Integer untilVal, String sign, Integer newVal) {
        assertThrows(IllegalArgumentException.class,
                () -> Operator.operation(sign, newVal, untilVal));
    }
}