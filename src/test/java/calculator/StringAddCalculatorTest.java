package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @Test
    @DisplayName(", 또는 :를 구분자로 가지는 문자열을 전달하는경우 분리한 숫자의 합을 반환한다")
    void separator_test() {
        assertThat(calculate("")).isEqualTo(0);
        assertThat(calculate("1,2")).isEqualTo(3);
        assertThat(calculate("1,2:3")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//,\n1,2,3", "//;\n1;2;3", "//!\n1!2!3"})
    @DisplayName("커스텀 구분자를 지정한경우에도 분리한 숫자의 합을 반환한다")
    void custom_separator_test(String input) {
        assertThat(calculate(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3","a,1,b","a,-1,3","!,B,-!"})
    @DisplayName("숫자 이외의 값 또는 음수를 전달하는경우 RuntimeException 을 던진다")
    void not_numeric_value_test(String input) {
        assertThatThrownBy(() -> {
            calculate(input);
        }).isInstanceOf(RuntimeException.class);
    }
}
