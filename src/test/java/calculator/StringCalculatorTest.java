package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @ParameterizedTest
    @DisplayName("조건에 맞는 문자열 연산 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10", "1 + 0 = 1", "1 - 2 = -1"}, delimiter = '=')
    void calculateTest(String value, Double expected) {
        assertThat(stringCalculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("문자열이 공백일 때 테스트")
    @NullSource
    void checkNullTest(String input) {
        assertThatThrownBy(() -> stringCalculator.checkNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("empty string");
    }
}
