package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("null 또는 빈 문자의 경우 0을 반환한다.")
    @Test
    void test01() {
        assertThat(Calculator.splitAndSum(null)).isEqualTo(Calculator.ZERO);
        assertThat(Calculator.splitAndSum("")).isEqualTo(Calculator.ZERO);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void test02() {
        int result = Calculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest(name = "숫자와 구분자(, :)가 입력될 경우 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,2|3", "1:2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    void test03(String input, int expected) {
        int result = Calculator.splitAndSum(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @Test
    void test04() {
        int result = Calculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값을 전달하는 경우 RuntimeException 에러 발생한다.")
    @ParameterizedTest(name = "양의 숫자 이외의 값을 전달하는 경우 RuntimeException 에러 발생한다.")
    @ValueSource(strings = {"-1", "A", "-1,5"})
    void test05(String input) {
        assertThatThrownBy(() -> Calculator.splitAndSum(input))
                .isExactlyInstanceOf(RuntimeException.class).hasMessageContaining("는 양수가 아닙니다.");
    }
}
