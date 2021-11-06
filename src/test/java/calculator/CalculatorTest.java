package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void plus() {
        // given
        String input = "1 + 2";

        // expect
        assertThat(calculator.calculate(input)).isEqualTo(3);
    }

    @Test
    void minus() {
        // given
        String input = "1 - 2";

        // expect
        assertThat(calculator.calculate(input)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        // given
        String input = "1 * 2";


        // expect
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @Test
    void divide() {
        // given
        String input = "4 / 2";

        // expect
        assertThat(calculator.calculate(input)).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void input_validation_fail(String input) {
        // expect
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 입력값 입니다. 공백을 입력하지 마세요.");
    }

}