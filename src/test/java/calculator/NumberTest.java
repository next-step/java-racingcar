package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"-1", "-3"})
    @DisplayName("음수가 들어오면 예외를 반환한다.")
    void negative_numbers_throw_error(String input) {
        assertThatThrownBy(() -> Number.parse(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("0보다 작을 수 없습니다.");
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"#", "a"})
    @DisplayName("숫자 이외의 값이 들어오면 예외를 반환한다.")
    void except_numbers_throw_error(String input) {
        assertThatThrownBy(() -> Number.parse(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    @DisplayName("두 숫자를 더할 수 있다.")
    void add_two_number() {
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        assertThat(number1.add(number2)).isEqualTo(new Number(3));
    }
}
