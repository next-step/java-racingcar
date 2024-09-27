package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_숫자_하나() {
        int result = StringAddCalculator.splitAndSum("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("숫자 두개를 콤마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void splitAndSum_콤마_구분자() {
        int result = StringAddCalculator.splitAndSum("4,3");
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("구분자를 콤마(,) 또는 콜론(:) 으로 사용하여 모든 숫자의 합을 반환한다.")
    void splitAndSum_콤마_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("4,3:7");
        assertThat(result).isEqualTo(14);
    }

    @Test
    @DisplayName("'//'와 '\n' 문자 사이에 원하는 커스텀 구분자를 사용하여 모든 숫자의 합을 반환한다.")
    void splitAndSum_커스텀_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n4;3;7");
        assertThat(result).isEqualTo(14);
    }

    @Test
    @DisplayName("숫자 이외의 값 또는 음수를 입력할 경우 RuntimeException 예외가 발생한다.")
    void splitAndSum_음수_또는_숫자외의값() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-4,3,7");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
