import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("더하기 테스트")
    @ParameterizedTest
    @CsvSource(value = { "3:1", "4:2", "6:3", "2:2" }, delimiter = ':')
    void plus(String num1, String num2) {
        assertThat(calculator.calculate(num1 + " + " + num2))
                .isEqualTo(String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2)));
    }

    @DisplayName("빼기 테스트")
    @ParameterizedTest
    @CsvSource(value = { "3:1", "4:2", "6:3", "2:2" }, delimiter = ':')
    void minus(String num1, String num2) {
        assertThat(calculator.calculate(num1 + " - " + num2))
                .isEqualTo(String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2)));
    }

    @DisplayName("곱하기 테스트")
    @ParameterizedTest
    @CsvSource(value = { "3:1", "4:2", "6:3", "2:2" }, delimiter = ':')
    void multiply(String num1, String num2) {
        assertThat(calculator.calculate(num1 + " * " + num2))
                .isEqualTo(String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2)));
    }

    @DisplayName("나누기 테스트")
    @ParameterizedTest
    @CsvSource(value = { "3:1", "4:2", "6:3", "2:2" }, delimiter = ':')
    void divide(String num1, String num2) {
        assertThat(calculator.calculate(num1 + " / " + num2))
                .isEqualTo(String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2)));
    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1 + 2 / 3=1", "2 * 3 - 5=1", "1 + 2 * 3 / 9=1" }, delimiter = '=')
    void calculate(String input, String result) {
        assertThat(calculator.calculate(input))
                .isEqualTo(result);
    }

    @DisplayName("예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "", " ", "1 2", "1+2", "1 + 2 +" })
    void calculate_with_exception(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}
