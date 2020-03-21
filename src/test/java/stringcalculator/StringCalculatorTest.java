package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
    public void divideByZeroThrowsArithmeticException() {
        StringCalculator calculator = new StringCalculator();

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.operate("1 / 0"));
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> calculator.operate("1.1 / 0.0"));
    }

    @Test
    @DisplayName("주어진 문자열의 사칙 연산 결과를 리턴한다")
    public void operateStringReturnsOperationOfNumbers() {
        StringCalculator calculator = new StringCalculator();

        assertThat(calculator.operate("1 + 3 / 4 * 3")).isEqualTo(3);
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닌 기호가 포함된 경우 IllegalArgumentException가 발생한다")
    public void operateByInvalidOperatorThrowsIllegalArgumentException() {
        StringCalculator calculator = new StringCalculator();

        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.operate("1 & 3 ^ 3"));
    }

    @Test
    @DisplayName("입력 값이 공백이나 null일 경우 IllegalArgumentException가 발생한다")
    public void inputIsInvalidThrowsIllegalArgumentException() {
        StringCalculator calculator = new StringCalculator();

        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.operate("    "));
        assertThatIllegalArgumentException().isThrownBy(() ->
                calculator.operate(null));
    }
}
