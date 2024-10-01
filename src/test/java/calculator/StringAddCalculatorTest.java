package calculator;

import calculator.exception.StringAddException;
import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    void splitAndSum_null() {
        int result = splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_빈문자() {
        int result = splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        int result = splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(StringAddException.class);
    }

    @Test
    void splitAndSum_숫자가아닌문자() {
        assertThatThrownBy(() -> splitAndSum("1,2,C"))
                .isInstanceOf(StringAddException.class);
    }
}
