package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void 빈_문자열_공백문자_일때() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 구분자_없이_숫자_하나_일때() {
        assertThat(StringAddCalculator.splitAndSum("12")).isEqualTo(12);
    }

    @Test
    void default_쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void default_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void default_쉼표_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    void custom_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void default_custom_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2,3")).isEqualTo(6);
    }

    @Test
    void 음수일_경우() {
        Assertions.assertThrows(RuntimeException.class, ()->
                StringAddCalculator.splitAndSum("1;-2"));
    }
}
