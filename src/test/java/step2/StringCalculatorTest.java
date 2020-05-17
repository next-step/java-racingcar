package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Step2 - 문자열 계산기 테스트")
class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @DisplayName("문자열 사칙연산 계산")
    @Test
    void calculate() {
        String testInput = "2 + 10 * 4 / 2";
        int result = calc.calculate(testInput);
        assertThat(result).isEqualTo(24);
    }
}