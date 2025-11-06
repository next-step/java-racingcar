package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest{


    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_and_null_is_0_return(String text) {
        assertThat(StringCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @Test
    void 쉼표구분자_split_sum() {
        int result = StringCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론구분자_split_sum() {
        int result = StringCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_split_sum() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\na;2;3", "//;\n-1;2;3"})
    void 숫자가_아니거나_음수일_경우_예외처리(String text){
        assertThatThrownBy(() -> StringCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
