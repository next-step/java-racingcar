package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DisplayName("문자열 덧셈 계산기 테스트")
public class StringSumCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum은_빈_문자열이나_공백문자인_경우_0을_반환한다(String input) {
        assertThat(StringSumCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1|1", "1,2|3"}, delimiter = '|')
    void splitAndSum은_숫자를_콤마_구분자로_입력할_경우_숫자의_합을_반환한다(String input, int expected) {
        assertThat(StringSumCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "1:2|3", "1:2:3|6", "1:2,3|6"}, delimiter = '|')
    void splitAndSum은_구분자를_콤마_외에_콜론을_사용할_수_있다(String input, int expected) {
        assertThat(StringSumCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @Test
    void splitAndSum은_커스텀_구분자를_지정할_수_있다() {
        assertThat(StringSumCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum은_음수를_입력받은_경우_런타임_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            StringSumCalculator.splitAndSum("1;-2;3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void splitAndSum은_숫자가_아닌_문자열을_입력받은_경우_런타임_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            StringSumCalculator.splitAndSum("a;2;3");
        }).isInstanceOf(NumberFormatException.class);
    }
}
