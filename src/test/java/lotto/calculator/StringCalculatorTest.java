package lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("문자열 계산기 생성")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void create(String input) {
        assertThatThrownBy(() -> new StringCalculator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null 또는 공백일 수 없습니다");
    }

    @DisplayName("문자열 계산")
    @ParameterizedTest
    @CsvSource(value = {
            "8 + 2,10",
            "8 - 2,6",
            "8 * 2,16",
            "8 / 2,4",
            "1 - 2 + 3 * 4 + 5 / 2,6",
            "1 - 100 / 3 * 2 + 51,-15"
    })
    void calculate(String input, Long result) {
        assertThat(new StringCalculator(input).calculate()).isEqualTo(result);
    }
}