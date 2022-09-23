package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void null_또는_빈문자열() {
        assertThat(parseAndSum(null)).isEqualTo(0);
        assertThat(parseAndSum("")).isEqualTo(0);
        assertThat(parseAndSum("   ")).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(parseAndSum("1")).isEqualTo(1);
    }

    @Test
    void 숫자_구분자로_두개이상() {
        assertThat(parseAndSum("1,2")).isEqualTo(3);
        assertThat(parseAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(parseAndSum("//-\n1-2-3")).isEqualTo(6);
        assertThat(parseAndSum("//#\n1#2#3#4")).isEqualTo(10);
    }

}
