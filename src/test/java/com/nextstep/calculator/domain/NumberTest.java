package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @DisplayName("문자열을 인자로 받아서 객체를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("createTestResource")
    void createTest(String value, Number expectedNumber) {
        Number number = Number.of(value);

        assertThat(number).isEqualTo(expectedNumber);
    }
    public static Stream<Arguments> createTestResource() {
        return Stream.of(
                Arguments.of("1", Number.of("1")),
                Arguments.of("0", Number.of("0")),
                Arguments.of("-1", Number.of("-1"))
        );
    }

    @DisplayName("인자로 전달된 문자열을 숫자로 변환할 수 없는 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "", "a1", "12cb"})
    void creatFailTest(String invalidValue) {
        assertThatThrownBy(() -> Number.of(invalidValue)).isInstanceOf(InvalidNumberException.class);
    }
}
