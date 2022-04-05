package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("Null 혹은 빈문자 테스트")
    void splitAndSumNullOrEmpty() throws Exception {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("깔끔한 숫자 하나만 들어왔을 때")
    void splitAndSumOnlyOneNumber() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("깔끔한 숫자가 들어왔는데 음수일 경우 예외")
    void splitAndSumOnlyOneNumberWithNegative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("쉼표구분자만 있을 때")
    public void splitAndSumCommaSeparator() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표, 콜론 구분자 혼용")
    public void splitAndSumSeparatorWithCommaAndColon() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Custom 구분자가 사용됐을 때")
    public void splitAndSumCustomSeparator() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열중에 음수가 포함됐을 경우")
    public void splitAndSumNegativeNumber() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}