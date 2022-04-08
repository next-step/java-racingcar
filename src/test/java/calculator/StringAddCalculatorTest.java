package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈문자열이 입력되면, 0을 리턴한다.")
    public void splitAndSum_nullOrEmpty() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나가 입력되면, 그대로 리턴한다.")
    public void splitAndSum_singleNumber() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("여러개의 숫자가 쉽표 구분자로 입력되면, 그 숫자들을 모두 더한값을 리턴한다.")
    public void splitAndSum_commaDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("여러개의 숫자가 쉽표 또는 콜론 구분자로 입력되면, 그 숫자들을 모두 더한값을 리턴한다.")
    public void splitAndSum_commaOrColonDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 주어지면, 이어지는 숫자들을 구분하여 더한값을 리턴한다.")
    public void splitAndSum_customDelimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함되면, 런타임 예외를 호출한다.")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함되면, 런타임 예외를 호출한다.")
    public void splitAndSum_notNumber() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,ㅋ,3"))
                .isInstanceOf(NumberFormatException.class);
    }
}
