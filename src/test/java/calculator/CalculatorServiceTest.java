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

        calculatorService.calculateLoop(testText1, calculator);

        Assertions.assertThat(calculator.result).isEqualTo(3);

        // V.해당부분 수행 시 오류 발생. 왜 그럴까? 어떻게 해결 가능할까?
//        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
//                .isThrownBy(() -> Assertions.assertThat(calculator.result).isEqualTo(3));
    }
}