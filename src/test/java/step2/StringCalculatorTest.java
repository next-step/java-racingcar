package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.StringCalculator;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2, 10", "2 - 3, -1", "2 - -3, 5" })
    @DisplayName("사칙연산을 모두 포함하는 테스트")
    void calculate(String param, String expected) {
        String actual = stringCalculator.calculateString(param);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 // 2", "2 + 3 * 4 /" })
    @DisplayName("사칙연산이 실패하는 케이스")
    void calculateFail(String param) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.calculateString(param);
        });
    }
}
