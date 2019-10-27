package step1.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("validIntegerEquations")
    void success_calculate_valid_integer_cases(String equation) {
        StringCalculator sut = new StringCalculator<>("Integer");
        assertThat(sut.calculate(equation)).isInstanceOf(Integer.class);
    }

    @ParameterizedTest
    @MethodSource("inValidIntegerEquations")
    void success_calculate_inValid_integer_cases(String equation) {
        StringCalculator sut = new StringCalculator<>("Integer");
        assertThatThrownBy(() -> sut.calculate(equation)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validIntegerEquations() {
        return Stream.of(
                Arguments.of("1 + 2 + 3 + 4"),
                Arguments.of("1 + 1 / 2 * 3"),
                Arguments.of("1 - 11 / 2 * 3"),
                Arguments.of("-2 * 11 / 11 + 3")
        );
    }

    private static Stream<Arguments> inValidIntegerEquations() {
        return Stream.of(
                Arguments.of("1 + 2 + 3 + 4 >> 10"),
                Arguments.of("1 + 1 / 0 * 3"),
                Arguments.of("1 - + 11 / 2 * 3"),
                Arguments.of("-12 * 11 / 11 + 3 3 4")
        );
    }
}
