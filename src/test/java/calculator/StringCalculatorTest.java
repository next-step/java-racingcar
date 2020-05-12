package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = StringCalculator.of();
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 +100 + 23000, 23102", "7 + 7 + 106, 120"})
    void plus(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5 - 100 - 90, -185", "-7 - 7 - 9, -23"})
    void minus(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 * 101, 202", "-7 * 5, -35", "-8 * 9, -72"})
    void multiply(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"100 / 2 , 50", "7 + -7 / 2, 0", "-2 / 2, -1"})
    void divide(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }

    @DisplayName("복합 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "-1 * 2 + -5 + -3 / 2, -5", "-1 - -1 + 8, 8"})
    void calculate(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }
}