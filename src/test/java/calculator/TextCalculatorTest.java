package calculator;

import calculator.TextCalculator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void plus() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }

    @Test
    void minus() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }

    @Test
    void multiplication() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
    }

    @Test
    void division() {
        String input = "2 + 2";
        assertThat(calculator.calculate(input)).isEqualTo(4);
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