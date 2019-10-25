package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void add() {
        StringCalculator calculator =  new StringCalculator();
        String input = "3 + 2";
        int output = calculator.calculator(input);
        assertThat(output).isEqualTo(5);
    }

    @Test
    public void subtract() {
        StringCalculator calculator = new StringCalculator();
        String input = "5 - 4";
        int output = calculator.calculator(input);
        assertThat(output).isEqualTo(1);
    }

    @Test
    public void divide() {
        StringCalculator calculator = new StringCalculator();
        String input = "4 / 2";
        int output  =  calculator.calculator(input);
        assertThat(output).isEqualTo(2);
    }

    @Test
    public void multiply() {
        StringCalculator calculator = new StringCalculator();
        String input = "3 * 2";
        int output =  calculator.calculator(input);
        assertThat(output).isEqualTo(6);
    }

}
