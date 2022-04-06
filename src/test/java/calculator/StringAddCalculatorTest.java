package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열이거나_Null일_경우() {
        Assertions.assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        Assertions.assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 빈_문자_Null이_아닌_경우() {
        Assertions.assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        Assertions.assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
    }
}
