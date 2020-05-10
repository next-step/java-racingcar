package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자열로 연산을 하면 IllegalArgumentException 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "\n \t"})
    @NullSource
    void emptyString_thenThrowIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @DisplayName("사직연산 기호가가 아닌 기호로 연산을 하면 IllegalArgumentException 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2", "1 ** 3"})
    void notSupportedOperator_thenThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("1 ! 2"));
    }

    @DisplayName("잘못된 입력을 하면 IllegalArgumentException 예외 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 2 * *", "*"})
    void invalidInput_thenThrowIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("1 * 2 * *"));
    }

    @DisplayName("덧셈 연산을 지원한다.")
    @ParameterizedTest
    @CsvSource(value = {
        "1 + 2=3",
        "3 + 4=7",
        "2 + 3=5"
    }, delimiter = '=')
    void plus(String input, double result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("뺄샘 연산을 지원한다.")
    @ParameterizedTest
    @CsvSource(value = {
        "2 - 1=1",
        "2 - 3=-1",
        "2 - 5=-3"
    }, delimiter = '=')
    void minus(String input, double result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("곱셈 연산을 지원한다.")
    @ParameterizedTest
    @CsvSource(value={
        "2 * 1=2",
        "2 * 3=6",
        "-2 * -3 * -5=-30"
    }, delimiter = '=')
    void multiply(String input, double result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("나눗셈연산을 지원한다.")
    @ParameterizedTest
    @CsvSource(value={
        "2 / 1=2",
        "2 / 3="+2.0/3,
        "2 / 5="+2.0/5
    }, delimiter = '=')
    void divide(String input, double result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }

    @DisplayName("사직연산을 지원한다.")
    @ParameterizedTest
    @CsvSource(value={
        "2 + 3 * 4 / 2=10"
    }, delimiter = '=')
    void calculation(String input, double result) {
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }
}
