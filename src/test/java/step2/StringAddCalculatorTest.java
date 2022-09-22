package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    @DisplayName("요구사항 1: 주어진 문자열이 null 이거나 빈문자이면 0 반환")
    void string_null_or_empty(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("요구사항 2: 주어진 문자열이 숫자 하나 그 자체이면 해당 숫자를 반환")
    void string_only_single_number() {
        int result = StringAddCalculator.splitAndSum("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 3: 주어진 문자열이 쉼표를 구분자로 가진다면 쉼표로 구분된 숫자들의 합을 반환")
    void string_with_comma_delimiter() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 4: 주어진 문자열이 쉼표 혹은 콜론을 구분자로 가진다면 쉼표와 콜론으로 구분된 숫자들의 합을 반환")
    void string_with_comma_or_colon_delimiter() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 5: “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정한 문자열이면 커스텀 구분자로 구분된 숫자들의 합을 반환")
    void string_with_custom_delimiter() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 6: 주어진 문자열을 구분자로 나눴을 때 음수가 포함되어 있다면 NegativeNumberException 발생")
    void string_with_negative_number() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(NegativeNumberException.class);
    }

    @Test
    @DisplayName("요구사항 6*: 주어진 문자열을 구분자로 나눴을 때 숫자가 아닌 문자가 포함되어 있다면 InvalidStringException 발생")
    void string_with_non_number() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,a,3"))
                .isInstanceOf(InvalidStringException.class);
    }

}