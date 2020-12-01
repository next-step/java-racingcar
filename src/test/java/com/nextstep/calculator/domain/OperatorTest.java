package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {
    @DisplayName("사칙연산 문자열을 인자로 전달해 원하는 사칙연산 객체를 찾을 수 있다.")
    @ParameterizedTest
    @MethodSource("createTestSource")
    void createTest(String operator, Operator expected) {
        assertThat(Operator.of(operator)).isEqualTo(expected);
    }
    public static Stream<Arguments> createTestSource() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("*", Operator.MULTIPLY),
                Arguments.of("/", Operator.DIVIDE)
        );
    }

    @DisplayName("잘못된 사칙연산 문자열로 객체 찾기 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"+ ", " ", "", "123", "abc", "안녕하세요"})
    void createFailTest(String invalidValue) {
        assertThatThrownBy(() -> Operator.of(invalidValue)).isInstanceOf(InvalidOperatorException.class);
    }

    @DisplayName("두개의 Number를 전달받아서 사칙연산에 맞는 계산을 수행할 수 있다.")
    @ParameterizedTest
    @MethodSource("operateTestSource")
    void operateTest(Operator operator, Number expected) {
        Number one = Number.of("1");
        Number two = Number.of("2");

        assertThat(operator.operate(one, two)).isEqualTo(expected);
    }
    public static Stream<Arguments> operateTestSource() {
        return Stream.of(
                Arguments.of(Operator.PLUS, Number.of("3")),
                Arguments.of(Operator.MINUS, Number.of("-1")),
                Arguments.of(Operator.DIVIDE, Number.of("0")),
                Arguments.of(Operator.MULTIPLY, Number.of("2"))
        );
    }

    @DisplayName("0으로 나눌 경우 예외가 발생한다.")
    @Test
    void operateFailTest() {
        Number one = Number.of("1");
        Number zero = Number.of("0");

        assertThatThrownBy(() -> Operator.DIVIDE.operate(one, zero))
                .isInstanceOf(ArithmeticException.class);
    }
}