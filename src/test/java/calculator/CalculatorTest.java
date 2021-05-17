package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void name1() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void name() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("3 + 2");
        assertThat(result).isEqualTo(5);

        int result2 = calculator.calculate("3 - 2");
        assertThat(result2).isEqualTo(1);

        int result3 = calculator.calculate("3 * 2");
        assertThat(result3).isEqualTo(6);

        int result4 = calculator.calculate("3 / 2");
        assertThat(result4).isEqualTo(1);

        int result5 = calculator.calculate("3 * 2 + 4 / 2 - 3");
        assertThat(result5).isEqualTo(2);

        int result6 = calculator.calculate("3 / 2 + 4 - 2 * 3");
        assertThat(result6).isEqualTo(9);

    }
}
