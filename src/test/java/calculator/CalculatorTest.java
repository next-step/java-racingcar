package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest(name = "덧셈 연산이 가능하다.")
    @CsvSource(value = {"1 + 2, 3", "4 + 5, 9", "100 + 200, 300"})
    public void additionTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "뺄셈 연산이 가능하다.")
    @CsvSource(value = {"2 - 1, 1", "4 - 5, -1", "100 - 100, 0"})
    public void subtractionTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "곱셈 연산이 가능하다.")
    @CsvSource(value = {"2 * 1, 2", "4 * -5, -20", "100 * 0, 0"})
    public void multiplicationTest(String input, int result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

}