package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = { "2, 3, 5.0" })
    @DisplayName("덧셈 테스트")
    void plus(double left, double right, String excepted) {
        String result = stringCalculator.plus(left, right);

        assertThat(excepted).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 3, -1.0" })
    @DisplayName("뺄셈 테스트")
    void minus(double left, double right, String excepted) {
        String result = stringCalculator.minus(left, right);

        assertThat(excepted).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 3, 6.0" })
    @DisplayName("곱셈 테스트")
    void multiply(double left, double right, String excepted) {
        String result = stringCalculator.multiply(left, right);

        assertThat(excepted).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 4, 0.5" })
    @DisplayName("나눗셈 테스트")
    void division(double left, double right, String excepted) {
        String result = stringCalculator.division(left, right);

        assertThat(excepted).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void checkNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.checkNull(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "  " })
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void checkEmpty(String param) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.checkEmpty(param);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "+", "-", "*", "/" })
    @DisplayName("사칙연산 기호인 경우")
    void correctSign(String sign) {
        stringCalculator.checkSign(sign);
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "1", "a", "%" })
    @DisplayName("사칙연산 기호가 아닌 경우")
    void notCorrectSign(String sign) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.checkSign(sign);
        });
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 테스트")
    void testAll() {
    }
}
