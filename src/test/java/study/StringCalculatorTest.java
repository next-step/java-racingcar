package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 음수() {
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("-2,1:");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_mismatch() {
        assertThatThrownBy(() -> {
            StringCalculator.splitAndSum("/;1;2;3");
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 커스텀_구분자() {
        assertThat(StringCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 빈값_또는_null() {
        assertThat(StringCalculator.splitAndSum(null)).isZero();
        assertThat(StringCalculator.splitAndSum("")).isZero();
    }

    @Test
    void 콜론_구분자() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 컴마_구분자() {
        assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 숫자_하나() {
        assertThat(StringCalculator.splitAndSum("0")).isZero();
    }


}
