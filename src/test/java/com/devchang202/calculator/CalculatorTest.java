package com.devchang202.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    public static Calculator calculator = new Calculator();

    @Test
    void add() {
        int a = (int)(Math.random() * 100);
        int b = (int)(Math.random() * 100);
        int result = calculator.add(a, b);
        assertThat(result).isEqualTo(a + b);
    }

    @Test
    void substrate() {
        int a = (int)(Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int result = calculator.substrate(a, b);
        assertThat(result).isEqualTo(a - b);
    }

    @Test
    void divide() {
        int a = 50;
        int b = 2;
        int result = calculator.divide(a, b);
        assertThat(result).isEqualTo(25);
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    calculator.divide(a, 0);
                });
    }

    @Test
    void multiply() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);
        int result = calculator.multiply(a, b);
        assertThat(result).isEqualTo(a * b);
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideStringForisOperator")
    void isOperator_ShouldReturnTrueForOperators(String input) {
        assertThat(calculator.isOperator(input)).isTrue();
    }

    public static Stream<Arguments> provideStringForisOperator() {
        return Stream.of(
            Arguments.of("+", true),
            Arguments.of("-", true),
            Arguments.of("*", true),
            Arguments.of("/", true),
            Arguments.of("1234", false),
            Arguments.of(" ", false),
            Arguments.of("#", false),
            Arguments.of("@", false)
            );
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideStringsForisBlank")
    void isBlank_ShouldReturnTrueForBlanks(String input, boolean expected) {
        assertThat(calculator.isBlank(input)).isEqualTo(expected);
    }

    public static Stream<Arguments> provideStringsForisBlank(){
        return Stream.of(
                Arguments.of("", true),
                Arguments.of(" ", true),
                Arguments.of("blank", false),
                Arguments.of("a", false),
                Arguments.of("1234", false)
        );
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideStringsForisNumber")
    void isNumber_ShouldReturnTrueForNumbers(String input, boolean expected) {
        assertThat(calculator.isNumebr(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForisNumber() {
        return Stream.of(
                Arguments.of("56", true),
                Arguments.of("", false),
                Arguments.of("+", false),
                Arguments.of("-", false),
                Arguments.of("*", false),
                Arguments.of("/", false),
                Arguments.of(" ", false)
        );
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideStringsForisNumber")
    void checkNumber(String input, boolean expected) {
        if (expected == false) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> {
                        calculator.checkNumber(input);
                    });
        }
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideStringForisOperator")
    void checkOperator(String input, boolean expected) {
        if (expected == false) {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> {
                        calculator.checkOperator(input);
                    });
        }
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideIntegerForcalculate")
    void calculate(String op, int a, int b, int result) {
        assertThat(calculator.calculate("+", a, b)).isEqualTo(result);
    }

    public static Stream<Arguments> provideIntegerForcalculate() {
        return Stream.of(
                Arguments.of("+", 36, 45, calculator.add(36, 45)),
                Arguments.of("-", 36, 45, calculator.substrate(36, 45)),
                Arguments.of("*", 36, 45, calculator.multiply(36, 45)),
                Arguments.of("/", 36, 45, calculator.divide(36, 45))
        );
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @ValueSource(strings = {"@", "a", "8"})
    void calculate_ShouldThrowIllegalArgumentException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(input, 1, 1);
                    calculator.calculate(input, 1, 1);
                    calculator.calculate(input, 1, 1);
                });
    }

    @Test
    void parseEquation_ShouldReturnSplitStringOfEquation() {
        assertThat(calculator.parseEquation("3 / 2 * 5 + 6 - 7"))
                .containsExactly("3", "/", "2", "*", "5", "+", "6", "-", "7");
        assertThat(calculator.parseEquation("8 + 5 * 7 + 7 - 6 - 135 / 7 * 0 - 1000"))
                .containsExactly("8", "+", "5", "*", "7", "+", "7", "-", "6", "-", "135", "/", "7", "*", "0", "-", "1000");
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @ValueSource(strings = {
            "+ 3 * 2",
            "3 + 2  * 3",
            "3 3 * 2 + 100",
            "3 * 2 % 5"})
    void parseEquation_ShouldThrowIllegalArgumentException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.parseEquation(input);
                });
    }

        @ParameterizedTest(name = "{index} {displayName} {arguments}")
        @MethodSource("provideEquationForgetResultOfCalculator")
    void getResultOfCalculator(String[] parsedEquation, int result) {
        assertThat(calculator.getResultOfCalculator(parsedEquation)).isEqualTo(result);
    }

    public static Stream<Arguments> provideEquationForgetResultOfCalculator() {
        return Stream.of(
                Arguments.of(calculator.parseEquation("2 + 3 * 4 / 2"), 10),
                Arguments.of(calculator.parseEquation("5 - 2 / 3 * 7 + 100"), 107),
                Arguments.of(calculator.parseEquation("3 - 3 * 100 / 5 - 30"), -30),
                Arguments.of(calculator.parseEquation("20 * 60 - 5 / 5 + 7 * 2"), 492)
        );
    }
}
