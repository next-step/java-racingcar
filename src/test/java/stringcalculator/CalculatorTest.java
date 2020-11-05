package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("더하기")
    @CsvSource(value = {"1 + 1=2"}, delimiter = '=')
    public void plus(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("빼기")
    @CsvSource(value = {"4 - 2=2"}, delimiter = '=')
    public void minus(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("곱하기")
    @CsvSource(value = {"2 * 2=4"}, delimiter = '=')
    public void multiply(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("나누기")
    @CsvSource(value = {"4 / 2=2"}, delimiter = '=')
    public void divide(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("사칙 연산을 모두 포함한 수식")
    @CsvSource(value = {"1 + 2 - 1 * 6 / 2=6"}, delimiter = '=')
    public void calculate_success(String input, int result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("유효하지 않은 연산 기호")
    public void calculate_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate("3 + 4 % 7"));
    }

    @Test
    @DisplayName("유효하지 않은 수식")
    public void calculate_fail_null() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(null)).withMessage("유효하지 않은 수식입니다.");
    }
}
