package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringCalculator.splitAndSum;

/**
 * @author : 0giri
 * @since : 2023/04/12
 */
public class StringCalculatorTest {

    @DisplayName("음수를 입력하면 IllegalArgumentException 예외가 발생한다")
    @Test
    void 음수_예외() {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("//와 \\n 사이에 커스텀 구분자를 지정할 수 있다")
    @Test
    void 커스텀구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("숫자들을 콜론구분자로 구분하면 합을 반환한다")
    @Test
    void 콜론구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("숫자들을 컴마구분자로 구분하면 합을 반환한다")
    @Test
    void 컴마구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @DisplayName("숫자 하나를 입력하면 해당 숫자를 반환한다")
    @Test
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @DisplayName("null 또는 빈문자열을 입력하면 0을 반환한다")
    @Test
    void null_빈문자열() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
}
