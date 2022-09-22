package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.StringAddCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringAddCalculatorTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    @DisplayName("빈 값이나 null을 calculate했을 때 0을 반환한다")
    void null_or_space(String input) {
        int result = calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4"})
    @DisplayName("1 개의 숫자 입력시 해당 값을 그대로 반환")
    void single_number(String input) {
        int result = calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("음수 입력시 예외를 던짐")
    void minus_number() {
        String input = "-1";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    calculate(input);
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2 3", "5,4 9", "11,63 74"}, delimiter = ' ')
    @DisplayName(", 구분자로 여러 개의 숫자 입력")
    void multi_number_(String input, int expected) {
        int result = calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:4 10", "1:1 2", "0:62 62"}, delimiter = ' ')
    @DisplayName(": 구분자로 여러 개의 숫자 입력")
    void multi_number_colon(String input, int expected) {
        int result = calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력된 delimiter를 사용해 계산")
    void custom_delimiter() {
        String input = "//;\n1;2;3";

        int result = calculate(input);

        assertThat(result).isEqualTo(6);
    }
}
