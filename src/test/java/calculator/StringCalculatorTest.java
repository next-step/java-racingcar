package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    //@Test
    public void splitTest() {
        String[] values = StringCalculator.split("2 + 5");
        assertThat(values).containsExactly("2", "+", "5");
    }

    //@Test
    public void blankTest() {
        int result = StringCalculator.isBlank("");
        assertThat(result).isEqualTo(0);
    }

    // @Test
    public void addTest() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    //@Test
    public void subtractTest() {
        int result = StringCalculator.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    // @Test
    public void multiplyTest() {
        int result = StringCalculator.calculate("4 * 6");
        assertThat(result).isEqualTo(24);
    }

    // @Test
    public void divideTest() {
        int result = StringCalculator.calculate("10 / 5");
        assertThat(result).isEqualTo(2);
    }

    //@Test
    public void complexCalculation() {
        int result = StringCalculator.calculate("2 + 1 * 5 - 3 / 4");
        assertThat(result).isEqualTo(3);
    }
}
