package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName(value = "문자열을 사칙연산 한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 * 2 * 2 * 2,16", "-1 * -1 / 2,0"})
    void stringCalculator(String str, int expected) {
        // given
        String source = str;

        // when
        int result = StringCalculator.calculator(source);

        // then
        assertThat(result).isEqualTo(expected);
    }
}