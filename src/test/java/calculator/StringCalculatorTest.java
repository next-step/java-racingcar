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

}
