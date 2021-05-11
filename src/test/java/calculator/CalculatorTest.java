package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void addTest() {
        assertThat(5).isEqualTo(calculator.add(2, 3));
    }

    @Test
    void subtractTest() {
        assertThat(5).isEqualTo(calculator.subtract(8, 3));
    }

    @Test
    void multiplyTest() {
        assertThat(6).isEqualTo(calculator.multiply(2, 3));
    }

    @Test
    void divideTest() {
        assertThat(2).isEqualTo(calculator.divide(6, 3));
    }

    @ParameterizedTest
    @NullSource()
    void nullCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.nullCheck(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"78", "45"})
    void operCheckTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.operCheck(input);
        });
    }
}
