package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @DisplayName("2단계_문자열 덧셈 계산기_요구사항1 - 빈 문자열을 입력하는 경우 0을 반환하는지를 확인")
    @Test
    void pass_empty_string() {
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @DisplayName("2단계_문자열 덧셈 계산기_요구사항2 - null 값을 입력하는 경우 0을 반환하는지를 확인")
    @Test
    void pass_null_value() {
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @DisplayName("2단계_문자열 덧셈 계산기_요구사항3 - 숫자 하나만 입력하는 경우 해당 숫자를 반환하는지 확인")
    @Test
    void pass_single_number_of_value() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName("2단계_문자열 덧셈 계산기_요구사항4 - 두개 이상의 숫자를 콤마 구분자를 기준으로 분리하여 각 숫자들의 합을 반환하는지 확인")
    @Test
    void split_and_sum_by_comma() {
        assertThat(splitAndSum("1,2")).isEqualTo(Integer.parseInt("3"));
    }

    @DisplayName("2단계_문자열 덧셈 계산기_요구사항5 - 두개 이상의 숫자를 콤마 구분자 뿐만 아니라 콜론 구분자도 포함해서 분리하여 각 숫자들의 합을 반환하는지 확인")
    @Test
    void split_and_sum_by_comma_and_colons() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("2단계_문자열 덧셈 계산기_요구사항6 - “//”와 “\\n” 사이에 위치하는 커스텀 구분자로 분리하여 각 숫자들의 합을 반환하는지 확인")
    @Test
    void split_and_sum_by_custom_delimiter() {
        assertThat(splitAndSum("//;\\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("2단계_문자열 덧셈 계산기_요구사항7 - 음수를 입력하는 경우 RuntimeException 예외가 발생되는지 확인")
    @Test
    void pass_negative_value_runtime_exception() {
        assertThatThrownBy(() -> splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);
    }
}
