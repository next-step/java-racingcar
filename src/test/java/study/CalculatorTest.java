package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest{

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 빈_문자열_and_null_is_0_return() {
        int result = stringCalculator.isEmptyOrNull("");
        assertThat(result).isEqualTo(0);

        result = stringCalculator.isEmptyOrNull(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 쉼표구분자_split_sum() {
        String[] splitResult = stringCalculator.split("1,2");

        assertThat(splitResult).containsExactly("1","2");

        int sumResult = stringCalculator.sum(splitResult);

        assertThat(sumResult).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론구분자_split_sum() {
        String[] splitResult = stringCalculator.split("1,2:3");

        assertThat(splitResult).containsExactly("1","2","3");

        int sumResult = stringCalculator.sum(splitResult);

        assertThat(sumResult).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_split_sum() {
        String[] customSplitResult = stringCalculator.searchCustom("//;\n1;2;3");

        assertThat(customSplitResult).containsExactly("1","2","3");

        int sumResult = stringCalculator.sum(customSplitResult);

        assertThat(sumResult).isEqualTo(6);
    }

    @Test
    void 숫자가_아니거나_음수일_경우_예외처리() throws Exception{
        String[] customSplitResult = stringCalculator.searchCustom("//;\n-1;2;3");

        assertThatThrownBy(() -> stringCalculator.sum(customSplitResult))
                .isInstanceOf(RuntimeException.class);
    }
}
