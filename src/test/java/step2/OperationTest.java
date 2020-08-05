package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperationTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2"}, delimiter = ':')
    void add(int a, int b) {
        assertThat(StringOperator.ADD.calculate(a, b)).isEqualTo(a + b);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2"}, delimiter = ':')
    void subtract(int a, int b) {
        assertThat(StringOperator.SUBTRACT.calculate(a, b)).isEqualTo(a - b);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2"}, delimiter = ':')
    void multiply(int a, int b) {
        assertThat(StringOperator.MULTIPLY.calculate(a, b)).isEqualTo(a * b);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2"}, delimiter = ':')
    void divide(int a, int b) {
        assertThat(StringOperator.DIVIDE.calculate(a, b)).isEqualTo(a / b);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0"}, delimiter = ':')
    void divideByZero(int a, int b) {
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> StringOperator.DIVIDE.calculate(a, b));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculate(String expression, int result) {
        assertThat(Operation.calculate(expression)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {" + "})
    void invalidExpressionOperand(String expression) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Operation.calculate(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ? 2 ", "2 2 2"})
    void invalidExpressionOperator(String expression) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Operation.calculate(expression));
    }

}
