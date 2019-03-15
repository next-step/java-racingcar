package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    public void 빈_문자열_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        String input = "";
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(0);

    }

    @Test
    public void null_문자열_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        String input = null;
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 숫자_하나를_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        String input = "1";
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 숫자_두개를_컴마로_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        String input = "1,2";
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 숫자_새개_이상을_컴마로_구분하여_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        String input = "1,2,3";
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 숫자_새개_이상을_콜론으로_구분하여_입력() {
        StringAddCalculator calculator = new StringAddCalculator();
        String input = "1:2:3";
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(6);
    }
}
