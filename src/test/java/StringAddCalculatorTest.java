import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 기능 테스트")
class StringAddCalculatorTest {

    @Test
    @DisplayName("비거나 null 값이 들어있는 경우 0 을 반환한다.")
    public void splitAndSumNullOrEmpty() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력하면, 해당 숫자를 반환한다.")
    public void splitAndSumOneNumber() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자를 입력할 경우, 구분된 문자열의 합을 반환한다.")
    public void splitAndSumWithComma() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론으로 구분자를 넣을 수 있다.")
    public void splitAndSumWithCommaOrColon() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("\"//\"와 \"\\n\" 사이에, 구분자를 커스텀할 수 있다.")
    public void splitAndSum_custom_Separator() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함되어있으면, RuntimeException 발생")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
