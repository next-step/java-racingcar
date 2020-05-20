package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Step2 - 문자열 계산기 테스트")
class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @DisplayName("정상식 계산")
    @ParameterizedTest
    @CsvSource(value = {"2 + 10 * 4 / 2:24", "9 + 11 * 4 / 5:16"}, delimiter = ':')
    void calc_정상(String testInput, int expected) {
        int result = calc.calculate(testInput);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("비정상식 계산")
    @ParameterizedTest
    @ValueSource(strings = {"+ 10 * 4 / 2","2+ 10 * 4 / 2","2 + 10 / 1 *",""})
    void calc_비정상(String testInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calc.calculate(testInput);
        });
    }
}
