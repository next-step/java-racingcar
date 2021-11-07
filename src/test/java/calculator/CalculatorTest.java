package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈")
    public void add() {
        assertThat(Calculator.calculate("1 + 2 + 3")).isEqualTo(6);
    }

    @Test
    @DisplayName("뺄셈")
    public void subtraction() {
        assertThat(Calculator.calculate("1 - 2 - 3")).isEqualTo(-4);
    }

    @Test
    @DisplayName("곱셈")
    public void multiplication() {
        assertThat(Calculator.calculate("1 * 2 * 3")).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈")
    public void division() {
        assertThat(Calculator.calculate("3 / 2 / 1")).isEqualTo(1);
    }

    @Test
    @DisplayName("나눗셈 분모 예외")
    public void divisionWithException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate("3 / 0 / 2"))
                .withMessage("denominator cannot used zero.");
    }

    @ParameterizedTest
    @DisplayName("복합 연산")
    @CsvSource(value = {
            "1 + 2 - 3 * 4 / 5, 0",
            "5 + 4 - 3 * 2 / 1, 12",
            "10 + 1 - 2 * 3 / 4, 6",
            "6 + 4 - 3 * 2 / 1, 14",
    })
    public void mixedOperations(String expression, String actual) {
        assertThat(Calculator.calculate(expression)).isEqualTo(Integer.parseInt(actual));
    }

    @Test
    @DisplayName("입력 값 오류(null)")
    public void InputExceptionWithNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(null))
                .withMessage("invalid expression : null");
    }

    @Test
    @DisplayName("입력 값 오류(empty string)")
    public void InputExceptionWithEmptyString() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(""))
                .withMessage("invalid expression : ");
    }

    @Test
    @DisplayName("입력 값 오류(arithmetic operation)")
    public void InputExceptionWithArithmeticOperation() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate("1 + 2 ! 3"))
                .withMessage("invalid operator : !");
    }
}
