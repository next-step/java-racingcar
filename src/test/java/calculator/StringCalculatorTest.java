package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생")
    void validateInputValue() {
        assertThatThrownBy(() -> stringCalculator.run(null)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> stringCalculator.run("")).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> stringCalculator.run(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("피연산자가 숫자가 아닐 경우 IllegalArgumentException 발생")
    void validateNumberValue() {
        assertThatThrownBy(() -> stringCalculator.run("a + 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForCalculate")
    @DisplayName("사칙 연산 모두 포함한 계산 테스트")
    void calculate(String input, double result) {
        assertThat(stringCalculator.run(input)).isEqualTo(result);
    }

    private static Stream<Arguments> provideStringsForCalculate() {
        return Stream.of(
                Arguments.of("2 + 3 * 4 / 2", "10"),
                Arguments.of("4 + 1 * 2 / 5", "2"),
                Arguments.of("6 - 1 * 8 / 2", "20")
        );
    }

    @Test
    @DisplayName("불완전한 계산식일 경우 IllegalArgumentException 발생")
    void calculateInvalidExpression() {
        assertThatThrownBy(() -> stringCalculator.run("2 + 3 * 4 / 2 +")).isInstanceOf(IllegalArgumentException.class);
    }
}
