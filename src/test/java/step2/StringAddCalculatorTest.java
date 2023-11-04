package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("null이나 빈 문자열이 들어온다면 0을 반환한다.")
    @NullAndEmptySource
    public void splitAndSumNullOrEmptyString(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 넣으면 입력한 숫자를 반환한다.")
    public void splitAndSumOneNumber() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분자 기준으로 숫자의 합을 반환한다.")
    public void splitAndSumWithCommaSeparator() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자를 기준으로 숫자의 합을 반환한다.")
    public void splitAndSumWithCommaAndSemiColon() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀한 구분자를 넣었을 때 숫자들의 합을 반환한다.")
    public void splitAndSumCustomSeparator() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 입력했을 경우 예외가 발생한다.")
    public void splitAndSumWithNegativeNumber() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("콤마, 세미콜론, /, '\n' 구분자와 숫자 이외의 값이 들어올 경우 예외가 발생한다.")
    public void splitAndSumWithSpecialCharacter() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,*:3"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,$3"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,#3'"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("2@3^^"))
                .isInstanceOf(RuntimeException.class);
    }
}
