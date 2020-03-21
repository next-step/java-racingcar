package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Test for 'plus'")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3", "12345, 12345, 24690", "-98765, -98765, -197530"})
    void plusTest(int left, int right, int expected) {
        assertThat(calculator.plus(left, right)).isEqualTo(expected);
    }

    @DisplayName("Test for 'minus'")
    @ParameterizedTest
    @CsvSource(value = {"3, 2, 1", "99999, 77777, 22222", "-53421, -53421, 0"})
    void minusTest(int left, int right, int expected) {
        assertThat(calculator.minus(left, right)).isEqualTo(expected);
    }

    @DisplayName("Test for 'multiply'")
    @ParameterizedTest
    @CsvSource(value = {"10, 10, 100", "0, 0, 0", "-324, -613, 198612"})
    void multiplyTest(int left, int right, int expected) {
        assertThat(calculator.multiply(left, right)).isEqualTo(expected);
    }

    @DisplayName("Test for 'division'")
    @ParameterizedTest
    @CsvSource(value = {"100, 10, 10", "6, 2, 3", "198612, -613, -324"})
    void divisionTest(int left, int right, int expected) {
        assertThat(calculator.division(left, right)).isEqualTo(expected);
    }
}
