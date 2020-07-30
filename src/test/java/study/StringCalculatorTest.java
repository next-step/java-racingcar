package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void calculate() {
        String expression = "2 + 3 * 4 / 2";

        StringCalculator calculator = new StringCalculator();
        int result = calculator.calcuate(expression);

        assertThat(result).isEqualTo(10);
    }
}
