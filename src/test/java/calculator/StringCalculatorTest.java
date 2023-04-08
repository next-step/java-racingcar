package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    void 빈문자열이면_0을_반환한다() {
        int actual = StringCalculator.splitAndSum("");

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void null이면_0을_반환한다() {
        int actual = StringCalculator.splitAndSum(null);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 정상입력이면_합을_반환한다() {
        int actual = StringCalculator.splitAndSum("1,2");
        int actual2 = StringCalculator.splitAndSum("1,2,3");
        int actual3 = StringCalculator.splitAndSum("1,2:3");
        int actual4 = StringCalculator.splitAndSum("4");

        assertThat(actual).isEqualTo(3);
        assertThat(actual2).isEqualTo(6);
        assertThat(actual3).isEqualTo(6);
        assertThat(actual4).isEqualTo(4);
    }

    @Test
    void 커스텀_구분자() {
        int actual = StringCalculator.splitAndSum("//;\\n1;2;3");
        int actual2 = StringCalculator.splitAndSum("//+\\n1+2,3");

        assertThat(actual).isEqualTo(6);
        assertThat(actual2).isEqualTo(6);
    }

    @Test
    void 음수_입력값() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//;\\n1;-2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자_이외_입력값() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("1,string:3")).isInstanceOf(RuntimeException.class);
    }
}
