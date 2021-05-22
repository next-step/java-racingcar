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
        assertThat(5).isEqualTo(calculator.
                calculate(2, 3, "+"));
    }

    @Test
    void subtractTest() {
        assertThat(5).isEqualTo(calculator.
                calculate(8, 3, "-"));
    }

    @Test
    void multiplyTest() {
        assertThat(6).isEqualTo(calculator.
                calculate(2, 3, "*"));
    }

    @Test
    void divideTest() {
        assertThat(2).isEqualTo(calculator.
                calculate(6, 3, "/"));
    }

    @ParameterizedTest
    @NullSource()
    void validateNullExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.validateNullException(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a b", "&@", "~!"})
    void validateOperatorExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.validateNumberOperatorException(input);
        });
    }
}
