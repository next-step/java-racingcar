package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("null 또는 빈 문자열을 넣으면 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSumWhenInputNullAndEmpty(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 넣으면 입력 값을 그대로 반환")
    @Test
    public void splitAndSumWhenInputSingleInteger() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("덧셈 연산 - 쉼표 구분자")
    @Test
    public void splitAndSumWhenInputCommaDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("덧셈 연산 - 쉼표 또는 콜론 구분자")
    @Test
    public void splitAndSumWhenInputCommaAndSemicolonDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("덧셈 연산 - 커스텀 구분자")
    @Test
    public void splitAndSumWhenInputCustomDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수가 하나라도 있으면 예외 발생")
    @Test
    public void splitAndSumWhenInputNegative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
