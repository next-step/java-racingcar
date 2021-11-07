package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void plus() {
        // given
        String input = "1 + 2";

        // expect
        assertThat(calculator.execute(input)).isEqualTo(3);
    }

    @Test
    void minus() {
        // given
        String input = "1 - 2";

        // expect
        assertThat(calculator.execute(input)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        // given
        String input = "1 * 2";


        // expect
        assertThat(calculator.execute(input)).isEqualTo(2);
    }

    @Test
    void divide() {
        // given
        String input = "4 / 2";

        // expect
        assertThat(calculator.execute(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("When divider is 0, throws ArithmeticException")
    void divide_divider_is_zero() {
        // given
        String input = "4 / 0";

        // expect
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0 은 나눗셈을 할 수 없습니다. 다시 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 , 1",
            "1 + 2, 3",
            "1 + 2 + 3, 6",
            "1 + 2 + 3 + 4, 10",
            "-1 , -1",
            "1 - 2, -1",
            "1 - 2 - 3, -4",
            "1 - 2 - 3 - 4, -8",
            "1 * 1, 1",
            "1 * 2 * 0, 0",
            "1 * 2 * 3, 6",
            "1 / 1, 1",
            "1 / 2, 0",
            "1 / 2 / 3, 0",
            "4 / 2, 2",
            "4 / 2 / 2, 1",
            "1 + 2 * 8 / 4, 6",
            "-1 + -1 + -1 / 3, -1",
            "2 * 2 + 2 * 2 + 2 * 2 + 2 * 2 / 7, 8"
    })
    void calculate_with_many_numbers(String input, int result) {
        // expect
        assertThat(calculator.execute(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "", "  ", "     "
    })
    void input_validation_fail(String input) {
        // expect
        assertThatThrownBy(() -> calculator.execute(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 입력값 입니다. 공백을 입력하지 마세요.");
    }

}