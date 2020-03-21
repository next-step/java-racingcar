package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @Test
    @DisplayName("주어진 문자열에서 숫자들의 덧셈 결과를 리턴한다")
    public void addOperationReturnsSumOfNumbers() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.operate("1 + 2")).isEqualTo(3);
        assertThat(calculator.operate("1 + 5")).isEqualTo(6);
        assertThat(calculator.operate("1 + 3 + 5")).isEqualTo(9);
    }

    @Test
    @DisplayName("주어진 문자열에서 숫자들의 뺄셈 결과를 리턴한다")
    public void minusOperationReturnsSubtractionOfNumbers() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.operate("1 - 2")).isEqualTo(-1);
        assertThat(calculator.operate("1 - 2 - 3")).isEqualTo(-4);
    }

    @Test
    @DisplayName("주어진 문자열에서 숫자들의 곱셈 결과를 리턴한다")
    public void multiplyOperationReturnsMultiplicationOfNumbers() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.operate("1 * 2")).isEqualTo(2);
        assertThat(calculator.operate("1 * 2 * 3")).isEqualTo(6);
    }

    @Test
    @DisplayName("주어진 문자열에서 숫자들의 곱셈 결과를 리턴한다")
    public void divideOperationReturnsDivisionOfNumbers() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.operate("1 / 2")).isEqualTo(1.0 / 2.0);
        assertThat(calculator.operate("1 / 2 / 3")).isEqualTo(1.0 / 2.0 / 3.0);
    }

    @Test
    @DisplayName("나눗셈 연산에서 0으로 나눌 때 ArithmeticException이 발생한다")
    public void divideByZeroThrowArithmeticException() {
        StringCalculator calculator = new StringCalculator();

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.operate("1 / 0"));
    }
}
