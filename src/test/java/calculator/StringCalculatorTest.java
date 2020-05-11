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

    @DisplayName("복합 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10"})
    void calculate(final String expression, final int expected) {
        assertThat(stringCalculator.calculate(expression)).isEqualTo(expected);
    }
}