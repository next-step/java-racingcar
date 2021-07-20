package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("나누기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"20 / 4:5", "100 / 1:100", "10 / 5:2", "9 / 3:3"}, delimiter = ':')
    void divisionTest(String input, int answer) {
        assertThat(stringCalculator.excute(input)).isEqualTo(answer);
    }

    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void inputEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.excute(input);
        }).withMessageMatching("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("입력 값이 null 일 경우 IllegalArgumentException throw 테스트")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.excute(null);
        }).withMessageMatching("입력 값이 null이거나 빈 공백 문자입니다.");
    }

}
