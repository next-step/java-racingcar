package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 + 5:6", "1 + 3 + 5:9"}, delimiter = ':')
    @DisplayName("주어진 문자열에서 숫자들의 덧셈 결과를 리턴한다")
    public void addOperationReturnsSumOfNumbers(String input, double expected) {
        assertThat(calculator.operate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "1 - 2 - 3:-4"}, delimiter = ':')
    @DisplayName("주어진 문자열에서 숫자들의 뺄셈 결과를 리턴한다")
    public void minusOperationReturnsSubtractionOfNumbers(String input, double expected) {
        assertThat(calculator.operate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "1 * 2 * 3:6"}, delimiter = ':')
    @DisplayName("주어진 문자열에서 숫자들의 곱셈 결과를 리턴한다")
    public void multiplyOperationReturnsMultiplicationOfNumbers(String input, double expected) {
        assertThat(calculator.operate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0.5", "1.0 / 4.0:0.25"}, delimiter = ':')
    @DisplayName("주어진 문자열에서 숫자들의 나눗셈 결과를 리턴한다")
    public void divideOperationReturnsDivisionOfNumbers(String input, double expected) {
        assertThat(calculator.operate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 / 0", "1.1 / 0.0"})
    @DisplayName("나눗셈 연산에서 0으로 나눌 때 ArithmeticException이 발생한다")
    public void divideByZeroThrowsArithmeticException(String input) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.operate(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 / 4 * 3:3", "2 * -3 / 2 + 1:-2"}, delimiter = ':')
    @DisplayName("주어진 문자열의 사칙 연산 결과를 리턴한다")
    public void operateStringReturnsOperationOfNumbers(String input, double expected) {
        assertThat(calculator.operate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 & 3 ^ 3"})
    @DisplayName("사칙 연산 기호가 아닌 기호가 포함된 경우 IllegalArgumentException가 발생한다")
    public void operateByInvalidOperatorThrowsIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.operate(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 공백이나 null일 경우 IllegalArgumentException가 발생한다")
    public void inputIsInvalidThrowsIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.operate(input));
    }
}
