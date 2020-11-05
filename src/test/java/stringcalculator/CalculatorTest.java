package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void create_calculator_instance() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("입력 값이 null")
    void input_null() {
        assertThatThrownBy(() -> {
            calculator.input(null);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("입력값이 null이거나 빈 문자열");
    }

    @Test
    @DisplayName("입력 값이 빈 문자열")
    void input_empty_string() {
        assertThatThrownBy(() -> {
            calculator.input(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 null이거나 빈 문자열");
    }

}