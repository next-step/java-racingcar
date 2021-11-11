package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("사칙연산 - 더하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 3:4"}, delimiter = ':')
    void 더하기(String input, int excepted) {
        assertThat(Calculator.calculate(input)).isEqualTo(excepted);
    }

    @DisplayName("사칙연산 - 빼기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 - 1:1", "2 - 3:-1"}, delimiter = ':')
    void 빼기(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }


    @DisplayName("사칙연산 - 곱하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 * 1:2", "2 * 3:6"}, delimiter = ':')
    void 곱하기(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("사칙연산 - 나누기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 / 2:1", "6 / 3:2"}, delimiter = ':')
    void 나누기(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("사칙연산 - 0으로 나누는 경우")
    @Test
    void 나누기를_0으로_하는_경우() {
        String input = "2 / 0";

        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @DisplayName("입력값이 공백인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void 입력값이_NULL_또는_공백인_경우(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 올바르지 않습니다.");
    }

    @DisplayName("유효하지 않은 연산자로 계산을 시도할 때")
    @Test
    void 유효하지_않은_연산자를_입력한_경우() {
        String input = "2 @ 2";
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 연산자 입니다.");
    }

    @DisplayName("다양한 수식이 올바르게 계산되는지 테스트")
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
