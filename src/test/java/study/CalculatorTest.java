package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Operator;
import step2.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @Test
    void stringCalculatorTest() {
        StringCalculator calculator = new StringCalculator("2 + 3 * 4 / 2");
        calculator.run();
        assertThat(10.0).isEqualTo(calculator.getResult());
    }

    @Test
    void emptyInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    StringCalculator calculator = new StringCalculator("");
                });
    }

    @Test
    void nullInputTest() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> {
                    StringCalculator calculator = new StringCalculator(null);
                });
    }

    @DisplayName("사칙연산 기호가 아닌 경우")
    @Test
    void unExpectedCharTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringCalculator calculator = new StringCalculator("1 & 2");
                    calculator.run();
                });
    }
}
