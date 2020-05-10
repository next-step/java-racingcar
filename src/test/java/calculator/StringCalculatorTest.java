package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생")
    void validateInputValue() {
        assertThatThrownBy(() -> stringCalculator.run(null)).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> stringCalculator.run("")).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> stringCalculator.run(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("피연산자가 숫자가 아닐 경우 IllegalArgumentException 발생")
    void validateNumberValue() {
        assertThatThrownBy(() -> stringCalculator.run("a + 1")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2,10", "4 + 1 * 2 / 5,2", "6 - 1 * 8 / 2,20" })
    @DisplayName("사칙 연산 모두 포함한 계산 테스트")
    void calculate(String input, double result) {
        assertThat(stringCalculator.run(input)).isEqualTo(result);
    }
}