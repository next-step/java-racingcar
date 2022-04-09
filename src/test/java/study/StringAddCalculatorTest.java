package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("null, 빈문자, 숫자하나 테스트")
    void splitAndSum_null_또는_빈문자() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("쉼표구분자 테스트")
    void splitAndSum_쉼표구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표,콜론 구분자 테스트")
    void splitAndSum_쉼표_또는_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void splitAndSum_custom_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함되었을때 테스트")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
