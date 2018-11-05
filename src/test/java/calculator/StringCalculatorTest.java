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
    public void 공백분리테스트() {
        String origin = "11 * 33";
        String[] values = StringCalculator.SPLIT_PATTERN.split(origin);
        assertThat(values.length).isEqualTo(3);
    }

    @Test
    public void 문자만추출() {
        String origin = "12 + 34 - 56 / 78";
        String[] values = StringCalculator.SPLIT_PATTERN.split(origin);

        List<String> operatorList = new ArrayList<>();
        for (String value : values) {
            Matcher matcher = StringCalculator.OPERATOR_PATTERN.matcher(value);
            if(matcher.matches()) {
                operatorList.add(value);
            }
        }

        assertThat(operatorList.size()).isEqualTo(3);
    }

    @Test
    public void 복합연산() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 숫자하나만() {
        int result = StringCalculator.calculate("3");

        assertThat(result).isEqualTo(3);
    }

}