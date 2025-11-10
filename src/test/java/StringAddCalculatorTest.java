import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringAddCalculatorTest {

    @Test
    void 빈_문자열이나_null일_경우에는_0을_반환한다() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void 숫자_하나를_문자열로_입력한_경우에는_해당_숫자를_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }
}
