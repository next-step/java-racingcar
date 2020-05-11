package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("계산기 프로그램을 실행했을 때 input과 output 값 비교하는 test")
    @ParameterizedTest
    @CsvSource({"1 + 2 + 3 + 4 + 5 + 6, 21", "1 * 3 * 10 / 5, 6",
                "9 + 9, 18", "991 + 9 - 2, 998"})
    public void checkWhetherOutputIsCorrect(String input, int output) {
        Calculator calculator = new Calculator();
        assertEquals(output, calculator.calculate(input));
    }

    @DisplayName("정수를 0으로 나눌 때 ArithmeticException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"10 / 0", "0 / 0"})
    public void test(String input) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    Calculator calculator = new Calculator();
                    calculator.calculate(input);
                });
    }

}