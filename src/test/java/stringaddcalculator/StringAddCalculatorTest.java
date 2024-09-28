package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    void splitAndSum_null() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_빈문자() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자_빈문자() {
        int result = StringAddCalculator.splitAndSum("//;\n");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_custom_숫자_하나() {
        int result = StringAddCalculator.splitAndSum("//;\n1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_negative_한글_문자() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("변수,2,3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_negative_custom_구분자_한글_문자_하나_포함() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n변수")).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_negative_custom_구분자_한글_문자_포함() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n변수;2;3")).isInstanceOf(RuntimeException.class);
    }

}
