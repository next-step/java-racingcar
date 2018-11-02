package calculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);

        result = StringCalculator.calculate("3 + 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("2 - 1");
        assertThat(result).isEqualTo(1);

        result = StringCalculator.calculate("4 - 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("2 * 3");
        assertThat(result).isEqualTo(6);

        result = StringCalculator.calculate("3 * 4");
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("4 / 2");
        assertThat(result).isEqualTo(2);

        result = StringCalculator.calculate("8 / 2");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 덧셈_뺄셈() {
        int result = StringCalculator.calculate("2 + 3 * 4");
        assertThat(result).isEqualTo(24);
    }

    @Test
    public void 숫자만추출() {
        String line = "21 + 356 * 42";
        String[] values = line.split("\\s");

        List<Integer> numberList = new ArrayList<>();
        for (String value : values) {
            Matcher matcher = StringCalculator.NUMBER_PATTERN.matcher(value);
            if(matcher.matches()) {

            }
        }


    }

}