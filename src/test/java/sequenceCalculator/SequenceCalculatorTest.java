package sequenceCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import sequenceCalculator.domain.TextSequenceCalculator;

public class SequenceCalculatorTest {

    TextSequenceCalculator calculator = new TextSequenceCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    void Input_NullOrEmpty_Then_Zero(String input) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void Input_OnlyNumber_Then_ReturnNumber() {
        int result = calculator.calculate("1");
        assertThat(result).isEqualTo(1);

        result = calculator.calculate("13");
        assertThat(result).isEqualTo(13);

        result = calculator.calculate("155");
        assertThat(result).isEqualTo(155);
    }

    @Test
    void SplitByComma_And_Sum() {
        int result = calculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void SplitByCommaOrColon_And_Sum() {
        int result = calculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void SpliyByCustomSeparator_And_Sum() {
        int result = calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void Input_NegativeNumber_Then_Exception(){
        assertThatThrownBy(() -> calculator.calculate("1,-2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void Input_Unavailable_Separator_Then_Exception(){
        /* ":", "," 만 가능한 구분자로 정의합니다. */
        assertThatThrownBy(() -> calculator.calculate("1^2^3"))
            .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> calculator.calculate("1&2&3"))
            .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> calculator.calculate("//;\n1~2~3"))
            .isInstanceOf(RuntimeException.class);
    }
}
