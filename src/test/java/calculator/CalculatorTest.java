package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 3:4"}, delimiter = ':')
    void 더하기(String input, int excepted) {
        assertThat(Calculator.calculate(input)).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 1:1", "2 - 3:-1"}, delimiter = ':')
    void 빼기(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"2 - 1:1", "2 - 3:-1"}, delimiter = ':')
    void 곱하기(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 / 2:1", "6 / 3:2"}, delimiter = ':')
    void 나누기(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }



    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_NULL_또는_공백인_경우(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 올바르지 않습니다.");
    }

    @Test
    void 유효하지_않은_연산자를_입력한_경우() {
        String input = "2 @ 2";
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 연산자 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
        "2 / 2 : 1",
        "6 / 3 + 2 : 4",
        "2 * 2 - 2 + 2 : 4",
        "1 : 1"
    }, delimiter = ':')
    void 다양한_수식_테스트(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }
}
