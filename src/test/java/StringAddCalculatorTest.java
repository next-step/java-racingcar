import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void 빈_문자열이나_null일_경우에는_0을_반환한다() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}
