package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    
    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        String[] textSplitArr = calculator.splitText(null);
        int[] numbers = calculator.StringArrToIntArr(textSplitArr);
        int result = calculator.calculate(numbers);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        String[] textSplitArr = calculator.splitText("1");
        int[] numbers = calculator.StringArrToIntArr(textSplitArr);
        int result = calculator.calculate(numbers);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        String[] textSplitArr = calculator.splitText("1,2");
        int[] numbers = calculator.StringArrToIntArr(textSplitArr);
        int result = calculator.calculate(numbers);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        String[] textSplitArr = calculator.splitText("1,2:3");
        int[] numbers = calculator.StringArrToIntArr(textSplitArr);
        int result = calculator.calculate(numbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        String[] textSplitArr = calculator.splitText("//;\n1;2;3");
        int[] numbers = calculator.StringArrToIntArr(textSplitArr);
        int result = calculator.calculate(numbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        String[] textSplitArr = calculator.splitText("-1,2,3");
        int[] numbers = calculator.StringArrToIntArr(textSplitArr);
        assertThatThrownBy(() -> calculator.validatePositive(numbers))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 포함되어 있습니다");
    }
}


