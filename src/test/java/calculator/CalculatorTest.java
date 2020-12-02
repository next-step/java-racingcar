package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
    private String num1 = "20";
    private String num2 = "10";

    @Test
    @DisplayName("덧셈 test")
    void additionTest() {
        String result = Calculator.calculate("+", num1, num2);
        assertThat(result).isEqualTo("30");
    }

    @Test
    @DisplayName("뺄셈 test")
    void subtractionTest() {
        String result = Calculator.calculate("-", num1, num2);
        assertThat(result).isEqualTo("10");
    }

    @Test
    @DisplayName("곱셈 test")
    void multiplicationTest() {
        String result = Calculator.calculate("*", num1, num2);
        assertThat(result).isEqualTo("200");
    }

    @Test
    @DisplayName("나눗셈 test")
    void divisionTest() {
        String result = Calculator.calculate("/", num1, num2);
        assertThat(result).isEqualTo("2");
    }

    @Test
    @DisplayName("사칙연산기호 아닐경우 test")
    void illegalOperatorTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String result = Calculator.calculate("?", num1, num2);
                }).withMessageMatching("\\S is not operator");
    }
}
