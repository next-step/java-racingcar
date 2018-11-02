package calculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void 덧셈검증() {
        calculatorAssert("2 + 3", 5);
    }


    @Test
    public void 뺄샘_검증() {
        calculatorAssert("3 - 1", 2);
    }


    @Test
    public void 곱셈_검증() {
        calculatorAssert("2 * 3", 6);
    }


    @Test
    public void 나눗샘_검증() {
        calculatorAssert("6 / 3", 2);
    }

    @Test
    public void 체이닝_연산검증() {
        calculatorAssert("6 + 3 - 2", 7);
        calculatorAssert("6 + 3 * 2 + 20", 38);
        calculatorAssert("6 / 3 - 2", 0);
        calculatorAssert("6 + 0 * 3 / 2", 9);
    }

    private void calculatorAssert(String input, int i) {
        int result = StringCalculator.calculate(input);
        Assertions.assertThat(result).isEqualTo(i);
    }
}