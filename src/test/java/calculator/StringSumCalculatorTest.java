package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSumCalculatorTest {

    @DisplayName("기본으로 쉼표와 콜론으로 문자열을 구분하고, 구분된 값을 합해서 반환한다.")
    @Test
    void split_string_value_with_default_delimiter_and_sum() {
        int resultWithComma = StringSumCalculator.splitAndSum("2,3");
        int resultWithColon = StringSumCalculator.splitAndSum("2;3");
        int resultWithAll = StringSumCalculator.splitAndSum("1,2;3");

        assertThat(resultWithComma).isEqualTo(5);
        assertThat(resultWithColon).isEqualTo(5);
        assertThat(resultWithAll).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 지정하여, 커스텀 구분자로 문자열을 구분하고 구분된 값들을 합하여 반환한다.")
    @Test
    void split_string_value_with_custom_delimiter_and_sum() {
        int result = StringSumCalculator.splitAndSum("//#\n1#2#3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("Null이나 빈값이 들어오면 0을 반환한다.")
    @Test
    void return_0_when_argument_is_null_or_empty() {
        int resultFromNull = StringSumCalculator.splitAndSum(null);
        int resultFromEmpty = StringSumCalculator.splitAndSum("");

        assertThat(resultFromNull).isZero();
        assertThat(resultFromEmpty).isZero();
    }

    @DisplayName("숫자 이외의 값이나 음수를 전달하면, RuntimeException 예외를 발생시킨다.")
    @Test
    void throw_RuntimeException_when_argument_contains_non_number_or_negative() {
        assertThatThrownBy(() -> StringSumCalculator.splitAndSum("-1,2")).isInstanceOf(RuntimeException.class).hasMessage("숫자 외 문자, 음수는 입력할 수 없습니다.");
        assertThatThrownBy(() -> StringSumCalculator.splitAndSum("@@")).isInstanceOf(RuntimeException.class).hasMessage("숫자 외 문자, 음수는 입력할 수 없습니다.");
    }

    @DisplayName("숫자 한개를 입력하면 그 값을 반환한다.")
    @Test
    void return_one_value_when_nums_size_is_one() {
        assertThat(StringSumCalculator.splitAndSum("1")).isEqualTo(1);
    }
}
