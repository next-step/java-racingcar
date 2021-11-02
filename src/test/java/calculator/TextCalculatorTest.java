package calculator;

import calculator.TextCalculator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class TextCalculatorTest {

    TextCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TextCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 2=4", "2 + 2 + 2 + 2=8", "1 + 2 + 0=3"}, delimiter = '=')
    void plus(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 2=0", "1 - 2 - 3=-4", "10 - 2=8"}, delimiter = '=')
    void minus(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 1=1", "1 * 2 * 3=6", "0 * -999=0"}, delimiter = '=')
    void multiplication(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 1=1", "1 * 2 * 3=6", "0 * -999=0"}, delimiter = '=')
    void division(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @Test
    void mix() {
        String input = "2 + 3 * 4 / 2";
        assertThat(calculator.calculate(input)).isEqualTo(10);
    }

    @Test
    void operator() {
        Operator plus = Operator.getOperator("+");
        assertThat(plus).isEqualTo(Operator.PLUS);

        Operator minus = Operator.getOperator("-");
        assertThat(minus).isEqualTo(Operator.MINUS);

        Operator multiplication = Operator.getOperator("*");
        assertThat(multiplication).isEqualTo(Operator.MULTIPLICATION);

        Operator division = Operator.getOperator("/");
        assertThat(division).isEqualTo(Operator.DIVISION);
    }

    @Test
    void throwExceptionIfWrongOperator() {
        assertThatThrownBy(() -> Operator.getOperator("%")).isInstanceOf(IllegalArgumentException.class);
    }
}