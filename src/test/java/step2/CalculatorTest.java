package step2;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("더하기 테스트")
    void calculatorAddTest() {
        String input = "2 + 3 + 4 + 2";
        Calculator calculator = new Calculator(input);
        assertThat(11.0).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("빼기 테스트")
    void  calculatorMinusTest() {
        String input = "10 - 5 - 5 - 5";
        Calculator calculator = new Calculator(input);
        assertThat(-5.0).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("곱셈 테스트")
    void calculatorMultiplicationTest() {
        String input = "2 * 3 * 4 * 10";
        Calculator calculator = new Calculator(input);
        assertThat(240.0).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void calculatorDivisionTest() {
        String input = "100 / 2 / 2 / 2 / 2";
        Calculator calculator = new Calculator(input);
        assertThat(6.25).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("입력 값이 null일 경우")
    void calculatorInputNullTest() {
        String input = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Calculator calculator = new Calculator(input);
                }).withMessageContaining("null");
    }

    @Test
    @DisplayName("빈 공백 문자일 경우")
    void calculatorInputBlankTest() {
        String input = "   ";
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Calculator calculator = new Calculator(input);
        }).withMessageContaining("blank");
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닌 경우")
    void calculatorInputNotOperatorTest() {
        String input = "2 / 4 $ 3 @ 1";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        }).withMessageContaining("invalid operator");
    }

}
