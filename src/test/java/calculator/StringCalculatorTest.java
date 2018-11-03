package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = null;

    @Before
    public void setup() {
        stringCalculator = new StringCalculator(new CalculatorFactory() {

        });
    }

    @Test
    public void 덧셈() {
        int result = stringCalculator.calculator("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 빼기() {
        int result = stringCalculator.calculator("5 - 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = stringCalculator.calculator("2 * 3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    public void 나눗셈() {
        int result = stringCalculator.calculator("4 / 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 덧셈곱셈() {
        int result = stringCalculator.calculator("2 + 3 * 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 덧셈곱셈나눗셈() {
        int result = stringCalculator.calculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}