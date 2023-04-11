package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈문자열 또는 null 값 체크 테스트")
    void splitAndSum_null_또는_빈문자열() {
        int actual = splitAndSum(null);
        assertThat(actual).isEqualTo(0);

        actual = splitAndSum("");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void splitAndSum_컴마구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void splitAndSum_컴마_또는_콜론_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_커스텀_구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_음수() {
        assertThatThrownBy(()-> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
