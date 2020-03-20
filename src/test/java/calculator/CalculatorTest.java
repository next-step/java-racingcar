package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2=3", "1 + 2 + 3=6"}, delimiter = '=')
    @DisplayName("덧셈 테스트")
    public void additionTest(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2=-1", "5 - 3 - 1=1", "3 - 6=-3"}, delimiter = '=')
    @DisplayName("뺄셈 테스트")
    public void subtractionTest(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 3=3", "1 * 3 * 2=6", "2 * 5 * 3=30"}, delimiter = '=')
    @DisplayName("곱셈 테스트")
    public void multiplicationTest(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 3=0", "3 / 1=3", "5 / 5=1"}, delimiter = '=')
    @DisplayName("나눗셈 테스트")
    public void divisionTest(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }


}
