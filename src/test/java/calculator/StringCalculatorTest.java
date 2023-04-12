package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("음수가 포함되어있을떄 exception 반환")
    void 음수() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2:3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("콜론과 컴마 구분자로 각각의 숫자 구분하여 합을 반환")
    void 콜론과_컴마_구분자() {
        assertThat(StringCalculator.splitAndSum("1,2:3"))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 구분자로 각각의 숫자 구분하여 합을 반환")
    void 컴마구분자() {
        assertThat(StringCalculator.splitAndSum("1,2"))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 하나일때 정상 리턴")
    void 숫자_하나() {
        assertThat(StringCalculator.splitAndSum("1"))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값일 경우 0 반환")
    void 빈문자열_null() {
        assertThat(StringCalculator.splitAndSum(null))
                .isEqualTo(0);
        assertThat(StringCalculator.splitAndSum(""))
                .isEqualTo(0);
    }
}
