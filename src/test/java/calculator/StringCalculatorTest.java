package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 발생시킨다")
    @NullAndEmptySource
    void isBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.apply(input);
        });
    }

    @ParameterizedTest
    @DisplayName("덧셈한 결과를 반환한다")
    @CsvSource(value = {"2 + 1 = 3", "999 + 1 = 1000", "0 + 1 = 1"}, delimiter = '=')
    void add(String input, int expected) {
        assertThat(cal.apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("뺄셈한 결과를 반환한다")
    @CsvSource(value = {"2 - 1 = 1", "999 - 1 = 998", "0 - 1 = -1"}, delimiter = '=')
    void subtract(String input, int expected) {
        assertThat(cal.apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("곱셈한 결과를 반환한다")
    @CsvSource(value = {"2 * 1 = 2", "-1 * 1 = -1", "0 * 2 = 0", "-2 * 0 = 0"}, delimiter = '=')
    void multiply(String input, int expected) {
        assertThat(cal.apply(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("나눗셈한 결과를 반환한다")
    @CsvSource(value = {"2 / 1 = 2", "1 / 1 = 1", "0 / 1 = 1"}, delimiter = '=')
    void divide(String input, int expected) {
        assertThat(cal.apply(input)).isEqualTo(expected);
    }
}