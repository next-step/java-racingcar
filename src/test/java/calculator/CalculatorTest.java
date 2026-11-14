package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {


    @ParameterizedTest
    @CsvSource({"'1,2', 3", "'1,2,3', 6", "'1:2:3', 6"})
    void 쉼표_또는_콜론을_구분자로_가지는_문자열의_합을_구한다(String input, int expected) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(expected);
    }


    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_또는_null일_경우_0을_반환한다(String input) {
        Assertions.assertThat(Calculator.sum(input)).isEqualTo(0);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "-1,2,3",
            "1:-2:3",
            "//;\n-1;2;3",
            "//;\n1;2;-3"
    })
    void 음수가_포함될_경우_런타임_예외가_발생한다(String input) {
        Assertions.assertThatThrownBy(() -> Calculator.sum(input))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    void 숫자_이외의_값이_포함되면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Calculator.sum("[,2,3"))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    void 커스텀_구분자를_가지는_문자열의_합을_반환한다() {
        Assertions.assertThat(Calculator.sum("//;\n1;2;3")).isEqualTo(6);
    }







}
