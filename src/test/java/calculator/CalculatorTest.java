package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by kohyusik on 25/10/2019.
 */
@DisplayName("계산기")
public class CalculatorTest {

    @DisplayName("덧셈 연산")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "4 + 5:9"}, delimiter = ':')
    void add(String input, int output) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("뺄셈 연산")
    @ParameterizedTest
    @CsvSource(value = {"12 - 3:9", "4 - 5:-1", "10 - 10:0"}, delimiter = ':')
    void subtract(String input, int output) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("곱셈 연산")
    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, delimiter = '=', resources = "/calculator/multiply.csv")
    void multiply(String input, int output) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("나눗셈 연산")
    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, delimiter = '!', resources = "/calculator/divide.csv")
    void divide(String input, int output) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("혼합 연산")
    @ParameterizedTest
    @CsvFileSource(resources = "/calculator/operate.csv")
    void operate(String input, int output) {
        int result = Calculator.calculate(input);
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("빈 입력 예외")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void illegalArgumentTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Calculator.calculate(input);
                });
    }

    @DisplayName("지원하지 않는 연산 입력 예외")
    @ParameterizedTest
    @ValueSource(strings = {"4 | 5", "2 ^ 6"})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Calculator.calculate(input);
                });
    }
}
