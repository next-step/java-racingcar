package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("입력값이 빈 문자열 또는 null일 경우 0 반환")
    void inputIsEmptyOrNull() {
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("입력값이 쉼표 또는 콜론을 구분자로 가지는 문자열일 경우 구분자를 기준으로 분리한 숫자의 합 반환")
    void delimiterIsCommaOrColon() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 앞부분의 //와 \\n 사이에 위치하는 분자를 커스텀 구분자로 사용한다")
    void customDelimiter() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }
}
