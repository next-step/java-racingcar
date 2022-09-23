package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void null_또는_빈문자열() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
        assertThat(splitAndSum("   ")).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 숫자_구분자로_두개이상() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(splitAndSum("//-\n1-2-3")).isEqualTo(6);
        assertThat(splitAndSum("//#\n1#2#3#4")).isEqualTo(10);
    }

    @Test
    void 숫자_이외의_값_혹은_음수() {
        assertThatThrownBy(() -> {
            splitAndSum("1,-2");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            splitAndSum("1,a");
        }).isInstanceOf(RuntimeException.class);
    }


}
