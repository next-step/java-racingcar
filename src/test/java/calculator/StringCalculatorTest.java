package calculator;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    @Test
    public void test_checkCalculatorText() {
        assertThat(StringCalculator.checkCalculatorText("1 + 2")).isEqualTo(true);
        assertThat(StringCalculator.checkCalculatorText("1 + 5 * 4 / 1 - 1")).isEqualTo(true);
        assertThat(StringCalculator.checkCalculatorText("1 ! 5 * 4 / 1 - 1")).isEqualTo(false);
    }

    @Test
    public void test_extractExpressions() {
        assertThat(StringCalculator.extractOperators("1 + 222 * 4 / 3 - 2"))
                .isEqualTo(Arrays.asList("+", "*", "/", "-"));
    }

    @Test
    public void test_extractOperands() {
        assertThat(StringCalculator.extractOperands("13 + 2 * 4 / 3 - 2"))
                .isEqualTo(Arrays.asList(13, 2, 4, 3, 2));
    }

    @Test
    public void test_selectCalculator() throws Exception {
        assertThat(StringCalculator.selectCalculator("+")).isEqualTo(Calculator.ADD);
        assertThat(StringCalculator.selectCalculator("-")).isEqualTo(Calculator.SUBTRACT);
        assertThat(StringCalculator.selectCalculator("*")).isEqualTo(Calculator.MULTIPLY);
        assertThat(StringCalculator.selectCalculator("/")).isEqualTo(Calculator.DIVIDE);
    }

    @Test
    public void test_calculate() throws Exception {
        assertThat(StringCalculator.calculate("2 + 3 - 1 * 4 / 2")).isEqualTo(8);
        assertThat(StringCalculator.calculate("22 / 2 - 1 * 4 / 2")).isEqualTo(20);
    }

}