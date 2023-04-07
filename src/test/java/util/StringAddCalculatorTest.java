package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static util.StringAddCalculator.*;

public class StringAddCalculatorTest {
    @DisplayName("빈문자열 또는 null 값 체크")
    @Test
    void splitAndSum_빈문자열_null() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void splitAndSum_숫자_두개() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void splitAndSum_구분자_쉼표_콜론() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_음수_전달() {
        assertThatThrownBy(() -> splitAndSum("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_구분자_커스텀() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }
}

