package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringAddCalculator.splitAndSum;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("null 또는 빈값을 입력했을 때 0으로 반환되는데 성공")
    void null_또는_space() {
        assertThat(splitAndSum("")).isEqualTo(0);
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자로 된 한 개의 문자열을 입력했을 때 해당 문자열을 정수로 반환하는데 성공")
    void 문자열_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("여러 개의 숫자로 된 문자열을 입력했을 떄 숫자의 합을 반환하는데 성공")
    void 문자열_쉼표_구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("여러 개의 숫자로 된 문자열에 쉼표와 콜론 구분자가 있을 때 숫자의 합을 반환하는데 성공")
    void 문자열_쉼표_콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열에 음수로 된 숫자가 포함되어 있을 때 익셉션을 발생하며 실패")
    void 숫자_음수() {
        assertThatThrownBy(() -> {
            splitAndSum("1,2:-3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열에 콜론 외 다른 구분자가 포함되어 있을 때 숫자의 합을 반환하는데 성공")
    void 커스텀_구분자() {
        assertThat(splitAndSum("//;\n1;2")).isEqualTo(3);
    }
}
