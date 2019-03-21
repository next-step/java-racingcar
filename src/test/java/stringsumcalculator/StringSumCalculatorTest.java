package stringsumcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSumCalculatorTest {
    private StringSumCalculator stringSumCalculator;

    @Before
    public void setUp() {
        stringSumCalculator = new StringSumCalculator();
    }

    @Test(expected = RuntimeException.class)
    public void 음수일경우() {
        String input = "1,3:-10";
        stringSumCalculator.calculate(input);
    }

    @Test(expected = RuntimeException.class)
    public void 숫자가아닐경우() {
        String input = "test";
        stringSumCalculator.calculate(input);
    }

    @Test
    public void null_or_빈값을입력했을경우() {
        String input = "";
        int result = stringSumCalculator.calculate(input);
        assertThat(result).isEqualTo(0);
        input = null;
        result = stringSumCalculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 쉼표_콜론_구분자입력() {
        String input = "1,2";
        int result = stringSumCalculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 숫자하나입력() {
        String input = "9";
        int result = stringSumCalculator.calculate(input);
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void 커스텀구분자입력() {
        String input = "//;\n1;2;3";
        int result = stringSumCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }
}
