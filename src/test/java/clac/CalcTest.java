package clac;

import calc.Calculation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalcTest {

    Calculation calculation = new Calculation();

    @Test
    @DisplayName("add test")
    void addTest() {
        assertThat(calculation.calculate(3, 5, "+")).isEqualTo(8);
    }

    @Test
    @DisplayName("sub test")
    void subTest() {
        assertThat(calculation.calculate(3, 5, "-")).isEqualTo(-2);
    }

    @Test
    @DisplayName("mul test")
    void mulTest() {
        assertThat(calculation.calculate(3, 1, "*")).isEqualTo(3);
    }

    @Test
    @DisplayName("div test")
    void divTest() {
        assertThat(calculation.calculate(3, 3, "/")).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("formula blank test")
    void formulaBalnkTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculation.calc(input);
                }).withMessageMatching("formula is blank");
    }

    @Test
    @DisplayName("not support operation test")
    void operationTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculation.calculate(3, 5, "%");
        }).withMessageMatching("not support operation");
    }

}
