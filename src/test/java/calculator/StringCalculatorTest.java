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
        assertThat(stringCalculator.execute(input)).isEqualTo(answer);
    }

    @DisplayName("빼기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "9 - 3:6", "100 - 25:75"}, delimiter = ':')
    void minusTest(String input, int answer) {
        assertThat(stringCalculator.execute(input)).isEqualTo(answer);
    }

    @DisplayName("곱하기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4 * 5:20", "1 * 10:10", "100 * 100:10000", "5 * 0:0"}, delimiter = ':')
    void multiplicationTest(String input, int answer) {
        assertThat(stringCalculator.execute(input)).isEqualTo(answer);
    }

    @DisplayName("나누기 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"20 / 4:5", "100 / 1:100", "10 / 5:2", "9 / 3:3"}, delimiter = ':')
    void divisionTest(String input, int answer) {
        assertThat(stringCalculator.execute(input)).isEqualTo(answer);
    }

    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void inputEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.execute(input);
        }).withMessageMatching("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("입력 값이 null 일 경우 IllegalArgumentException throw 테스트")
    @Test
    void inputNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.execute(null);
        }).withMessageMatching("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("사칙연산 기호가 아닌 문자가 포함되어 있을 경우 IllegalArgumentException throw 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"20 q 10", "5 . 3"})
    void inputNotOperationTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.execute(input);
        }).withMessageMatching("사칙연산 기호가 아닌 문자가 포함되어 있습니다.");
    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"20 + 10 - 20 / 2 * 2:10", "5 + 3 * 2 / 4 - 4:0"}, delimiter = ':')
    void calculateTest(String input, int answer) {
        assertThat(stringCalculator.execute(input)).isEqualTo(answer);
    }

    @DisplayName("0을 나눌 경우 IllegalArgumentException throw 테스트")
    @Test
    void divideZeroTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.execute("10 / 0");
        }).withMessageMatching("0으로 나눌 수 없습니다.");
    }
}
