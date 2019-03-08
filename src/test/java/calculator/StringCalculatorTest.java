package calculator;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testSubtract() {
        int result = StringCalculator.calculate("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testMultiply() {
        int result = StringCalculator.calculate("2 * 6");
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void testDivide() {
        int result = StringCalculator.calculate("6 / 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testCalculate() {
        int result = StringCalculator.calculate("6 + 3 / 2 * 6");
        assertThat(result).isEqualTo(24);
    }

    @Test
    public void testCalculate2() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2 + 10");
        assertThat(result).isEqualTo(20);
    }

}