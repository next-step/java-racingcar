package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringPlusCalculatorTest {
    @Test
    @DisplayName("공백(””) 또는 null을 문자열로 전달하는 경우")
    void 공백_또는_null을_문자열로_전달하는_경우() {
        assertThat(StringPlusCalculator.sumOfNumbers(null)).isEqualTo(0);
        assertThat(StringPlusCalculator.sumOfNumbers("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 전달하는 경우")
    void 숫자_하나를_문자열로_전달하는_경우() {
        assertThat(StringPlusCalculator.sumOfNumbers("1")).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3"})
    @DisplayName("쉼표(,) 를 구분자로 가지는 문자열을 전달하는 경우")
    void 쉼표를_구분자로_가지는_문자열을_전달하는_경우(String s) {
        assertThat(StringPlusCalculator.sumOfNumbers(s)).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표(,)와 콜론(:) 을 구분자로 가지는 문자열을 전달하는 경우")
    void 쉼표와_콜론을_구분자로_가지는_문자열을_전달하는_경우() {
        assertThat(StringPlusCalculator.sumOfNumbers("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자(쉼표(,)와 콜론(:) 제외)를 구분자로 가지는 문자열을 전달하는 경우")
    void 커스텀_구분자를_구분자로_가지는_문자열을_전달하는_경우() {
        assertThat(StringPlusCalculator.sumOfNumbers("//;\n1;2;3")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3"}) // "a,2,3", "//;\\na;2;3"
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는 경우")
    void 숫자_이외의_값_또는_음수를_전달하는_경우(String input) {
        assertThatThrownBy(() -> {
            StringPlusCalculator.sumOfNumbers(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
