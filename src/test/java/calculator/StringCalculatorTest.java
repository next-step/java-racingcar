package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("덧셈 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 + 5:9"}, delimiter = ':')
    void plusTest(String input, int answer) {
        assertThat(stringCalculator.excute(input)).isEqualTo(answer);
    }

}