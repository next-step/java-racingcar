package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("sum 테스트")
    void sumTest() {
        Calculator calculator = new Calculator("2 + 3");
        assertThat(calculator.sum(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("subtract 테스트")
    void subtractTest() {
        Calculator calculator = new Calculator("2 - 1");
        assertThat(calculator.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("divide 테스트")
    void divideTest() {
        Calculator calculator = new Calculator("4 / 2");
        assertThat(calculator.divide(4, 2)).isEqualTo(2.0);
    }

    @Test
    @DisplayName("divide 0 나누기 테스트")
    void failDivideTest() {
        Calculator calculator = new Calculator("4 / 0");
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> {
            calculator.divide(4, 0);
        });
    }

    @Test
    @DisplayName("multiply 테스트")
    void multiplyTest() {
        Calculator calculator = new Calculator("2 * 2");
        assertThat(calculator.multiply(2, 2)).isEqualTo(4.0);
    }

    @DisplayName("성공 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10.0", "2 + 3 * 4 - 2:18.0"}, delimiter = ':')
    void successCalculateTest(String input, Double result) {
        Calculator calculator = new Calculator(input);

        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @DisplayName("예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ", "2 + 3 a 1"})
    void failCalculateTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
            calculator.calculate();
        });
    }
}
