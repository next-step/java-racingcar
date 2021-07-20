package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("더하기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 + 5:9"}, delimiter = ':')
    void plusTest(String input, int answer) {
        assertThat(stringCalculator.excute(input)).isEqualTo(answer);
    }

    @DisplayName("빼기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "9 - 3:6", "100 - 25:75"}, delimiter = ':')
    void minusTest(String input, int answer) {
        assertThat(stringCalculator.excute(input)).isEqualTo(answer);
    }

    @DisplayName("곱하기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4 * 5:20", "1 * 10:10", "100 * 100:10000", "5 * 0:0"}, delimiter = ':')
    void multiplicationTest(String input, int answer) {
        assertThat(stringCalculator.excute(input)).isEqualTo(answer);
    }
}