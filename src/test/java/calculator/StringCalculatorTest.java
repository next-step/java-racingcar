package calculator;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void 곱셈() {
        try {
            int result = StringCalculator.calculate("");
        }catch (InputMismatchException e)
        {
            System.out.println("입력값이 올바르지않음");
        }
    }

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("2 - 2");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("10 / 5");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 짬뽕() {
        int result = StringCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }
}
