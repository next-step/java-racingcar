package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("null 값 혹은 빈문자열을 넣으면 0을 반환한다.")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("     ");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나가 입력된 경우, 해당 숫자값을 반환한다.")
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력값을 쉼표 구분자로 split 하여 합계를 반환한다.")
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("입력값을 쉼표 또는 컬럼 구분자로 split 하여 합계를 반환한다..")
    public void splitAndSum_쉼표_또는_컬럼_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자가 형식에 맞게 입력된 경우, 구분자로 문자열을 split 하여 합계를 반환한다.")
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값에 음수값이 존재하는 경우 RuntimeException 을 던진다.")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,-2,3")).isInstanceOf(RuntimeException.class);
    }
}
