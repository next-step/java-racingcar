package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("계산기 객체 생성을 성공한다.")
    @Test
    void create() {
        stringCalculator = new StringCalculator();
        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("입력값이 null일 경우 예외 발생을 성공한다.")
    @Test
    void inputValue_IsNull() {
        final String input = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> { stringCalculator.calculate(input); }
        );
    }

    @DisplayName("입력값이 공백일 경우 예외 발생을 성공한다.")
    @Test
    void inputValue_IsBlank() {
        final String input = " ";
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> { stringCalculator.calculate(input); }
        );
    }
}