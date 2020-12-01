package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
}