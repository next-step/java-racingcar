package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = StringCalculator.of();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @MethodSource("plus")
    void plus(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> plus() {
        return Stream.of(
            Arguments.of("2 + 100 + 23000", 23102),
            Arguments.of("7 + 7 + 106", 120),
            Arguments.of("15 + -20 + 49", 44)
        );
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @MethodSource("minus")
    void minus(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> minus() {
        return Stream.of(
            Arguments.of("5 - 100 - 90", -185),
            Arguments.of("-7 - 7 - 9", -23),
            Arguments.of("-9 - 100 - 12 - 77", -198)
        );
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @MethodSource("multiply")
    void multiply(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> multiply() {
        return Stream.of(
            Arguments.of("2 * 101", 202),
            Arguments.of("-7 * 5 * 2", -70),
            Arguments.of("-2 * 2 * 100", -400)
        );
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @MethodSource("divide")
    void divide(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> divide() {
        return Stream.of(
            Arguments.of("100 / 2 / 5", 10),
            Arguments.of("-8 / 2 / 2", -2),
            Arguments.of("-2 / 2", -1)
        );
    }

    @DisplayName("복합 연산 테스트")
    @ParameterizedTest
    @MethodSource("calculation")
    void calculate(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    static Stream<Arguments> calculation() {
        return Stream.of(
            Arguments.of("2 + 3 * 4 / 2", 10),
            Arguments.of("-1 * 2 + -5 + -3 / 2", -5),
            Arguments.of("-1 - -1 + 8", 8)
        );
    }
}