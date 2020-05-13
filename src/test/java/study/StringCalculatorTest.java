package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource({"1 + 2, 3", "0 + 99 + 1 + 2, 102", "+ 1 + 2, 3"})
    void plus(String input, double expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource({"10 - 2, 8", "1 - 1, 0", "1 - 2 - 3, -4", "- 2, -2"})
    void minus(String input, double expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource({"1 * 0, 0", "9 * 9, 81", "2 * -5, -10", "* 3 * 5, 0"})
    void multiply(String input, double expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource({"2 / 1, 2", "5 / 2, 2.5", "2 / 5 / 2, 0.2", "/ 2, 0"})
    void divide(String input, double expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("사칙연산 모두 포함하는 계산 테스트")
    @ParameterizedTest
    @CsvSource({
            "2 + 3 * 4 / 2, 10",
            "1 * 0 - 1 + 2 / 2, 0.5",
            "5 - 2 / 2 * 3 + 0.1, 4.6",
            "- 3 * -2 + 2 / 8, 1",
            "* 5 + 5 - 2 / 2, 1.5"})
    void calculate(String input, double expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("입력값이 null 또는 공백일 경우 IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  "})
    void nullOrEmptyInput_Then_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}
