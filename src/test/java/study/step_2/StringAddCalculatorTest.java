package study.step_2;

import org.junit.jupiter.api.Test;
import study.step_2.domain.Calculator;
import study.step_2.service.AddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    public void null_또는_빈문자() {
        AddCalculator addCalculator = new AddCalculator(new Calculator(null));
        int result = addCalculator.executeAdd(null);
        assertThat(result).isEqualTo(0);

        AddCalculator addCalculatorWithBlank = new AddCalculator(new Calculator(""));
        result = addCalculatorWithBlank.executeAdd("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 단일_숫자_계산() throws Exception {
        AddCalculator addCalculatorWithSingleNumber = new AddCalculator(new Calculator("1"));
        int result = addCalculatorWithSingleNumber.executeAdd("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 쉼표_또는_콜론_구분자() throws Exception {
        AddCalculator addCalculatorWithSingleNumber = new AddCalculator(new Calculator("1,2:3"));
        int result = addCalculatorWithSingleNumber.executeAdd("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 쉼표_구분자() throws Exception {
        AddCalculator addCalculatorWithSingleNumber = new AddCalculator(new Calculator("1,2"));
        int result = addCalculatorWithSingleNumber.executeAdd("1,2");
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void 커스텀_구분자() throws Exception {
        AddCalculator addCalculatorWithSingleNumber = new AddCalculator(new Calculator("//;\n1;2;3"));
        int result = addCalculatorWithSingleNumber.executeAdd(("//;\n1;2;3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 음수_예외반환() throws Exception {
        assertThatThrownBy(() -> new AddCalculator(new Calculator("-1,2:3")))
                .isInstanceOf(RuntimeException.class);
    }
}