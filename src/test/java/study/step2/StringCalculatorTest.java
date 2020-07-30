package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step2.StringCalculator;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void add() {
        assertThat(calculator.add(5, 10)).isEqualTo(15);
        assertThat(calculator.add(5, -5)).isEqualTo(0);
    }

    @Test
    public void subtract() {
        assertThat(calculator.subtract(5, -5)).isEqualTo(10);
        assertThat(calculator.subtract(5, 5)).isEqualTo(0);
    }

    @Test
    public void divide() {
        assertThat(calculator.divide(15, 3)).isEqualTo(5);
        assertThat(calculator.divide(9, 9)).isEqualTo(1);
    }

    @Test
    public void divide_ShouldThrow_ArithmeticException() {
        assertThatThrownBy(() -> calculator.divide(10, 0)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    public void divide_ShouldReturn_FlooredResult() {
        assertThat(calculator.divide(19, 3)).isEqualTo(6);
        assertThat(calculator.divide(391, 100)).isEqualTo(3);
    }

    @Test
    public void multiply() {
        assertThat(calculator.multiply(5, 10)).isEqualTo(50);
        assertThat(calculator.multiply(8, -9)).isEqualTo(-72);
        assertThat(calculator.multiply(928363, 0)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = { "3 + 5:8", "3 - 5:-2", "3 * 5:15", "3 / 5:0", "3 + 5 - 90 / 4 * 7:-140"}, delimiter = ':')
    public void calculate(String expression, int exceptedResult) {
        assertThat(calculator.calculate(expression)).isEqualTo(exceptedResult);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { "3+5", "3 $ 2", "- 3 + 6", "3.5 / 10", "10 / 2 * 5*2", "5 + 10 + 2 / 2 /", "5 / 0" })
    public void calculate_ShouldThrow_IllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }
}
