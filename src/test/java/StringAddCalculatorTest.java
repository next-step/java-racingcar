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

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,5:7", "20,30:50"}, delimiter = ':')
    void 숫자_두개를_콤마로_구분해서_입력할_경우_두_숫자의_합을_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6", "2:5;7", "20,30:40;90"}, delimiter = ';')
    void 콤마와_콜론을_구분자로_사용한_문자열의_합을_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }
}
