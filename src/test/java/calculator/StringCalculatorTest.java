package calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static calculator.AddStringCalculator.seperatorInput;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    @Test
    public void 문자열_덧셈_계산기() {
        int result = AddStringCalculator.addCalculator("3,5");

        assertThat(result).isEqualTo(20);
    }

    @Test
    public void 입력값_분리_테스트() {
        List<String> inputs = seperatorInput("3,5");

        assertThat(inputs.get(0)).isEqualTo("3");
        assertThat(inputs.get(1)).isEqualTo("5");
    }

    @Test
    public void 입력값_오류_테스트() {
        AddStringCalculator.checkInputValidation(null);
    }

    @Test
    public void 숫자_하나_입력() {
        AddStringCalculator.checkInputValidation("3");
    }

    @Test
    public void 합계_테스트() {
        assertThat(8).isEqualTo(Arrays.asList("3", "5"));
    }
}