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
    void calculateFromString(String input, int answer){
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculateFromString(input);
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("입력 값이 null 이거나 공백문자일 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void calculateFromString_error1(String input){
        StringCalculator stringCalculator = new StringCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateFromString(input);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 에러")
    @ParameterizedTest
    @ValueSource(strings = {"1 . 1", "1 1 1", "1 1"})
    void calculateFromString_error2(String input){
        StringCalculator stringCalculator = new StringCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateFromString(input);
        });
    }
}
