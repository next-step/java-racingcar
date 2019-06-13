package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void plus() {
        assertThat(stringCalculator.calculate(1, PLUS,2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(stringCalculator.calculate(3, MINUS,2)).isEqualTo(1);
    }

    @Test
    void multiply() {
        assertThat(stringCalculator.calculate(3, MULTIPLY,2)).isEqualTo(6);
    }

    @Test
    void divide() {
        assertThat(stringCalculator.calculate(4, DIVIDE,2)).isEqualTo(2);
    }

    @Test
    void divideByZeroThanFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.Operator.DIVIDE.calculator(4,0));
    }

    @Test
    void multiCalculator() {
        assertCalculator(2, PLUS, 3, 5);
        assertCalculator(3, MINUS, 1, 2);
        assertCalculator(4, DIVIDE, 2, 2);
        assertCalculator(2, MULTIPLY, 3, 6);
    }

    private void assertCalculator(int num, StringCalculator.Operator symbol, int num2, int result) {
        assertThat(stringCalculator.calculate(num, symbol, num2)).isEqualTo(result);
    }
}