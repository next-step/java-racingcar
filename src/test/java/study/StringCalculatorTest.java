package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @DisplayName("문자열 값에 따라 사칙연산을 수행")
    @Test
    void calculate() {
        String expression = "2 + 3 * 4 / 2";

        StringCalculator calculator = new StringCalculator(expression);
        int result = calculator.calculate();

        assertThat(result).isEqualTo(10);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 exception 발생")
    @Test
    void calculateWithInvalidSymbol() {
        String expression = "2 + 3 * 4 % 2";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator calculator = new StringCalculator(expression);
            calculator.calculate();
        });
    }
}
