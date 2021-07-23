package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 = 3", "3 - 1 = 2", "2 * 2 = 4", "6 / 2 = 3", "1 + 2 * 2 = 6", "2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    void calc(String input, int answer){
        int result = StringCalculator.calc(input);
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("입력 값이 null 이거나 공백문자일 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void calc_error_empty(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calc(input);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1 . 1", "1 1 1", "1 1"})
    void calc_error_operator(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calc(input);
        });
    }
}
