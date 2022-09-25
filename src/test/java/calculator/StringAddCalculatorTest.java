package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringAddCalculator.*;
import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    void null_or_space() {
        assertThat(splitAndSum("")).isEqualTo(0);
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 문자열_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 문자열_쉼표_구분자() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 문자열_컴마_구분자() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 숫자_음수() {
        assertThatThrownBy( ()-> {
            splitAndSum("1,2:-3");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자열_커스텀_구분자() {
        int result = splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
