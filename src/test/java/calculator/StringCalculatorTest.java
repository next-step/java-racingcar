package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void plus() {
        assertThat(stringCalculator.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void minus() {
        assertThat(stringCalculator.minus(3, 2)).isEqualTo(1);
    }

    @Test
    void multiply() {
        int result = stringCalculator.multiply(2,3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = stringCalculator.divide(4,2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void divideByZeroThanFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.divide(4,0));
    }

    @Test
    void multiCalculator() {
        assertCalculator(2, '+', 3, 5);
        assertCalculator(3, '-', 1, 2);
        assertCalculator(4, '/', 2, 2);
        assertCalculator(2, '*', 3, 6);
    }

    private void assertCalculator(int num, char symbol, int num2, int result) {
        assertThat(stringCalculator.calculate(num, symbol, num2)).isEqualTo(result);
    }
}