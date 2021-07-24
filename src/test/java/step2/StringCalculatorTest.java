package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    void plus() {
        int result = StringCalculator.calculate(new Formulas("2 + 3"));
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void minus() {
        int result = StringCalculator.calculate(new Formulas("5 - 2"));
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiply() {
        int result = StringCalculator.calculate(new Formulas("3 * 6"));
        assertThat(result).isEqualTo(18);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divide() {
        int result = StringCalculator.calculate(new Formulas("4 / 2"));
        assertThat(result).isEqualTo(2);
    }
}
