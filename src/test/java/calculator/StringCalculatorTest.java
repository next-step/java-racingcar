package calculator;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculator("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뻴셈() {
        int result = StringCalculator.calculator("5 - 3");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculator("5 * 5");
        assertThat(result).isEqualTo(25);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculator("12 / 3");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 연산() {
        int result = StringCalculator.calculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}