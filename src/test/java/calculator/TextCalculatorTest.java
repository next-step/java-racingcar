package calculator;

import calculator.TextCalculator.Operator;
import org.junit.jupiter.api.BeforeEach;
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
        String input = "2 + 3 * 4 / 2 + 1 - 6 + 10 - 11 * 191";
        assertThat(calculator.calculate(input)).isEqualTo(764);
    }

    @Test
    void operator() {
        Operator plus = Operator.getInstance("+");
        assertThat(plus).isEqualTo(Operator.PLUS);

        Operator minus = Operator.getInstance("-");
        assertThat(minus).isEqualTo(Operator.MINUS);

        Operator multiplication = Operator.getInstance("*");
        assertThat(multiplication).isEqualTo(Operator.MULTIPLICATION);

        Operator division = Operator.getInstance("/");
        assertThat(division).isEqualTo(Operator.DIVISION);
    }

    @Test
    void throwExceptionIfWrongOperator() {
        assertThatThrownBy(() -> Operator.getInstance("%")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Operator.getInstance("* *")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfIntegerOverFlow() {
        assertThatThrownBy(() -> calculator.calculate(Integer.MAX_VALUE + " + " + "1")).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void throwExceptionIfInputWrongValue() {
        assertThatThrownBy(() -> calculator.calculate("1" + "+ " + "1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("1" + " + " + " * " + "1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate("1" + " 1 " + " 2 " + "*")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculator.calculate(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfDivideByZero() {
        assertThatThrownBy(() -> calculator.calculate("1 / 0")).isInstanceOf(ArithmeticException.class);
    }
}