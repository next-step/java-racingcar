package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator =  new StringCalculator();
    }

    @Test
    public void addition() {
        String input = "2 + 3 * 4 / 2";
        int output = calculator.calculator(input);
        assertThat(output).isEqualTo(10);
    }

    @Test
    public void subtraction() {
        String input = "5 - 4";
        int output = calculator.calculator(input);
        assertThat(output).isEqualTo(1);
    }

    @Test
    public void divide() {
        String input = "4 / 2";
        int output  =  calculator.calculator(input);
        assertThat(output).isEqualTo(2);
    }

    @Test
    public void multiply() {
        String input = "3 * 2";
        int output = calculator.calculator(input);
        assertThat(output).isEqualTo(6);
    }

    @Test
    public void addPlusMinus() {
        String input = "2 + 3 * 4 / 2";
        int output = calculator.calculator(input);
        assertThat(output).isEqualTo(10);
    }

    @Test
    public void isValidOperatorCheck() {
        assertThatThrownBy(() -> {
            calculator.calculator("1 = 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isNullValueCheck() {
        assertThatThrownBy(() -> {
            calculator.calculator(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void isEmptyStringCheck() {
        assertThatThrownBy(() ->  {
           calculator.calculator("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
