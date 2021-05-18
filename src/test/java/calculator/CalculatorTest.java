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
        assertThat(5).isEqualTo(calculator.calculate("2 + 3"));
    }

    @Test
    void subtractTest() {
        assertThat(5).isEqualTo(calculator.calculate("8 - 3"));
    }

    @Test
    void multiplyTest() {
        assertThat(6).isEqualTo(calculator.calculate("2 * 3"));
    }

    @Test
    void divideTest() {
        assertThat(2).isEqualTo(calculator.calculate("6 / 3"));
    }

    @ParameterizedTest
    @NullSource()
    void handleNullExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.handleNullException(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 3", "1 & 7", "3 $ 4"})
    void handleOperatorExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.handleOperatorException(input);
        });
    }
}
