package string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈문자인 매개변수가 입력되면 0을 반환한다.")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 -> 숫자 변환시 NumberFormatException이 발생할 경우 IncludeNotNumberException 예외발생한다.")
    public void splitAndSum_숫자변환시_예외발생() throws Exception {
        String data = "A";

        ThrowingCallable result = () -> StringAddCalculator.splitAndSum(data);

        assertThatThrownBy(result)
            .isInstanceOf(IncludeNotNumberException.class)
            .hasMessageContaining("문자를 숫자로 변환중 숫자가 아닌 문자가 포함되어 있습니다. 문제발생문자 : " + data);
    }

    @Test
    @DisplayName("쉼표를 구분자로 가지는 문자열이 입력되면 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉽표와 콜론을 구분자로 가지는 문자열이 입력되면 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }
}