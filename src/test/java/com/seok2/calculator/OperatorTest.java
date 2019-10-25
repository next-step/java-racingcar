package com.seok2.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OperatorTest {


    static Stream<Arguments> operators() {
        return Stream.of(
            Arguments.of("+", Operator.PLUS),
            Arguments.of("-", Operator.MINUS),
            Arguments.of("*", Operator.MULTIPLY),
            Arguments.of("/", Operator.DIVIDE)
        );
    }

    static Stream<String> invalidOperators() {
        return Stream.of("", " ", null, "%");
    }


    static Stream<Arguments> addTestValues() {
        return Stream.of(
            Arguments.of(1, 2, 3),
            Arguments.of(4, 5, 9),
            Arguments.of(10, 2, 12)
        );
    }

    static Stream<Arguments> minusTestValues() {
        return Stream.of(
            Arguments.of(2, 1, 1),
            Arguments.of(5, 5, 0),
            Arguments.of(1, 3, -2)
        );
    }

    static Stream<Arguments> multiplyTestValues() {
        return Stream.of(
            Arguments.of(2, 1, 2),
            Arguments.of(5, 0, 0),
            Arguments.of(10, 3, 30)
        );
    }

    static Stream<Arguments> divideTestValues() {
        return Stream.of(
            Arguments.of(1, 1, 1),
            Arguments.of(6, 2, 3),
            Arguments.of(7, 2, 3)
        );
    }


    @ParameterizedTest
    @MethodSource("operators")
    void find(String input, Operator expected) {
        assertThat(Operator.find(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("invalidOperators")
    void findByInvalidOperators(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Operator.find(input));
    }

    @ParameterizedTest
    @MethodSource("addTestValues")
    void plus(int num1, int num2, int expected) {
        assertThat(Operator.PLUS.calculator(num1, num2)).isEqualTo(expected);
        assertThat(Operator.find("+").calculator(num1, num2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestValues")
    void minus(int num1, int num2, int expected) {
        assertThat(Operator.MINUS.calculator(num1, num2)).isEqualTo(expected);
        assertThat(Operator.find("-").calculator(num1, num2)).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("multiplyTestValues")
    void multiply(int num1, int num2, int expected) {
        assertThat(Operator.MULTIPLY.calculator(num1, num2)).isEqualTo(expected);
        assertThat(Operator.find("*").calculator(num1, num2)).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("divideTestValues")
    void divide(int num1, int num2, int expected) {
        assertThat(Operator.DIVIDE.calculator(num1, num2)).isEqualTo(expected);
        assertThat(Operator.find("/").calculator(num1, num2)).isEqualTo(expected);

    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> Operator.DIVIDE.calculator(10, 0))
            .isInstanceOf(ArithmeticException.class)
            .hasMessageContaining("/ by zero");
    }
}