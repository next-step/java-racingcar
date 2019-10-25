package com.seok2.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    static Stream<String> emptyStrings() {
        return Stream.of("", "   ", "         ", null);
    }

    static Stream<Arguments> expressions() {
        return Stream.of(
            Arguments.of("1 + 2 * 4 - 4 / 2", 4),
            Arguments.of("1 + 2 + 3 + 4 + 5", 15),
            Arguments.of("1 - 2 * 6 / 2", -3),
            Arguments.of("2 + 3 * 4 / 2", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("emptyStrings")
    void isEmpty(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.checkIsEmpty(input));
    }

    @ParameterizedTest
    @MethodSource("expressions")
    void evaluate(String input, int expected) {
        assertThat(calculator.evaluate(input)).isEqualTo(expected);
    }
}