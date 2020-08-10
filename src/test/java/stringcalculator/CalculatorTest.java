package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("입력 값이 null 인 경우")
    public void nullInputTest() {
        assertThatThrownBy(() -> {
            calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 공백 문자열이거나 null 입니다.");
    }

    @Test
    @DisplayName("입력 값이 공백 경우")
    public void blankInputTest() {
        assertThatThrownBy(() -> {
            calculator.calculate(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 공백 문자열이거나 null 입니다.");
    }



}