package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void 덧셈_검증() {
        calculatorAssert("2 + 3", 5);
    }

    @Test
    public void 뺄셈_검증() {
        calculatorAssert("2 - 3", -1);
    }

    @Test
    public void 곱셈_검증() {
        calculatorAssert("2 * 3", 6);
    }

    @Test
    public void 나눗셈_검증() {
        calculatorAssert("2 / 3", 0);
    }

    @Test
    public void 혼합연산_검증() {
        calculatorAssert("2 + 3 * 4 / 2", 10);
        calculatorAssert("2 * 3 + 4 - 2", 8);
        calculatorAssert("2 - 3 + 4 * 2", 6);
        calculatorAssert("2 + 3 - 4 / 2", 0);
    }


    private void calculatorAssert(String input, int expect) {
        int result = StringCalculator.calculaor(input);
        assertThat(result).isEqualTo(expect);
    }
}