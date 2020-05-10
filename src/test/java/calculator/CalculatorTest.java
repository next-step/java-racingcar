package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideExpression")
    @DisplayName("계산 테스트")
    void calculate(String expression, double result) {
        assertThat(Calculator.calculate(expression)).isEqualTo(result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백일 경우 Exception")
    void validationExpression(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidExpression")
    @DisplayName("입력 값이 올바른 경우가 아닐경우 Exception")
    void expression(String expression) {
        assertThatThrownBy(() -> Calculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideExpression() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", "10.0"),
                Arguments.of("1 + 3 + 5", "9.0"),
                Arguments.of("10 - 3 / 7", "1.0"),
                Arguments.of("1 + 3", "4.0"),
                Arguments.of("23 - 3 - 1 - 2", "17")
        );
    }

    private static Stream<Arguments> provideNotValidExpression() {
        return Stream.of(
                Arguments.of("2"),
                Arguments.of("+"),
                Arguments.of("2 + "),
                Arguments.of("- 2"),
                Arguments.of("2 + 1 -"),
                Arguments.of("2 1 3")
        );
    }
}
