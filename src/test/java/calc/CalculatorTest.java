package calc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 2 + 3:6", "1 + 2 + 3 + 4:10"}, delimiter = ':')
    void 덧셈테스트(String input, double result) {
        assertThat(new Calculator(input).getResult()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "1 - 2 - 3:-4", "1 - 2 - 3 - 4:-8"}, delimiter = ':')
    void 뺄셈테스트(String input, double result) {
        assertThat(new Calculator(input).getResult()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "1 * 2 * 3:6", "1 * 2 * 3 * 4:24"}, delimiter = ':')
    void 곱셈테스트(String input, double result) {
        assertThat(new Calculator(input).getResult()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0.5", "2 / 1 / 2:1", "6 / 2 / 3 / 4:0.25"}, delimiter = ':')
    void 나눗셈테스트(String input, double result) {
        assertThat(new Calculator(input).getResult()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 2 * 3 / 2:6", "4 - 2 * 7 - 5:9"}, delimiter = ':')
    void 복합연산테스트(String input, int result) {
        assertThat(new Calculator(input).getResult()).isEqualTo(result);
    }
}
