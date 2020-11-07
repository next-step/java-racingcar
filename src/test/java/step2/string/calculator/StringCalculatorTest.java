package step2.string.calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void create_calculator_instance() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("입력 값이 null인 경우 테스트")
    void input_null() {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Constants.INPUT_IS_NULL_OR_BLANK);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 빈 문자열인 경우 테스트")
    @ValueSource(strings = {"", "   "})
    void input_empty_string(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INPUT_IS_NULL_OR_BLANK);
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 아닌 경우")
    @ValueSource(strings = {"4 @ 7", "6 ) 2"})
    void input_not_arithmetic_operator(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.IS_NOT_VALID_OPERATOR);
    }

    @ParameterizedTest
    @DisplayName("계산기 기능 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2=10", "4 - 1 * 8 / 4=6"}, delimiter = '=')
    void calculate(String input, int expected) {
        assertEquals(stringCalculator.calculate(input), expected);
    }
}