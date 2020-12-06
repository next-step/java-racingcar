package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculateTest {

    @ParameterizedTest
    @CsvSource(value = {
        "2 + 3 * 4 / 2,10"
    })
    @DisplayName("입력한 문자열 계산 정상 수행")
    public void calculate(String input, int result) {
        assertThat(StringCalculate.calculate(input)).isEqualTo(result);
    }
}
