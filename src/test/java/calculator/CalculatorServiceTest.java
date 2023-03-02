package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    Calculator calculator = new Calculator();
    CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("사칙연산 계산기 테스트")
    void calculateLoop() {
        final String testText1 = "1 + 6 - 4 * 3 / 3";
        final String testText2 = "1 + -t + 6 - 4 * 3 / 3";

        calculatorService.calculateLoop(testText1, calculator);

        Assertions.assertThat(calculator.result).isEqualTo(3);

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.calculateLoop(testText2, calculator));
    }
}