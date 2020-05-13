package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @Test
    void stringCalculatorTest() {
        StringCalculator calculator = new StringCalculator("2 + 3 * 4 / 2");
        assertThat(10.0).isEqualTo(calculator.getResult());
    }

    @Test
    void addTest() {
        StringCalculator calculator = new StringCalculator("2 + 3");
        assertThat(5.0).isEqualTo(calculator.getResult());
    }

    @Test
    void minusTest() {
        StringCalculator calculator = new StringCalculator("2 - 3");
        assertThat(-1.0).isEqualTo(calculator.getResult());
    }

    @Test
    void multiplyTest() {
        StringCalculator calculator = new StringCalculator("20 * 3");
        assertThat(60.0).isEqualTo(calculator.getResult());
    }

    @Test
    void devideTest() {
        StringCalculator calculator = new StringCalculator("2 / 4");
        assertThat(0.5).isEqualTo(calculator.getResult());
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
                });
    }
}
