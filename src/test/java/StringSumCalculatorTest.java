import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringSumCalculatorTest {

    @DisplayName("빈문자나 null이 요청될 시 0으로 출력된다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSumNullOrEmpty(String input) {
        assertThat(StringSumCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("단일 숫자가 요청될 시 동일한 숫자가 출력된다.")
    @Test
    public void splitAndSumOneNum() {
        int result = StringSumCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("콤마 구분자로만 나뉘어져있을 시 모든수의 합이 출력된다.")
    @Test
    public void splitAndSumComma() {
        int result = StringSumCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("콤마 구분자와 콜론으로 나뉘어져있을 시 모든수의 합이 출력된다.")
    @Test
    public void splitAndSumCommaOrColon() {
        int result = StringSumCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자가 //\\n사이에 있을 시, 해당 구분자로 분리된 모든 수의 합이 출력된다.")
    @Test
    public void splitAndSumCustomSeparator() {
        int result = StringSumCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자에 음수가 포함되어있을 시 RuntimeException을 발생시킨다.")
    @Test
    public void splitAndSumContainsMinusThrowException() {
        assertThatThrownBy(() -> StringSumCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Minus not allowed");
    }
}
