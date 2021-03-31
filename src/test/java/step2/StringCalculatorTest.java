package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource({"2 + 4,6", "120 + 34,154", "2300 + 11 + 345,2656"})
    @DisplayName("덧셈 구현 확인")
    void add(String input, int expected) {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        calculator.setText(input);
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2 - 4,-2", "120 - 10 - 5,105", "111 - 34 - 42 - 2,33"})
    @DisplayName("뺄셈 구현 확인")
    void subtract(String input, int expected) {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        calculator.setText(input);
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2 * 4,8", "10 * 5 * 3,150", "11 * 22 * 4 * 5,4840"})
    @DisplayName("곱셈 구현 확인")
    void multiply(String input, int expected) {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        calculator.setText(input);
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"16 / 8,2", "12000 / 6 / 20 / 5,20", "45000 / 9 / 100,50"})
    @DisplayName("나눗셈 구현 확인")
    void divide(String input, int expected) {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        calculator.setText(input);
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값이 null일 때 예외처리 확인")
    void checkNull() {
        StringCalculator calculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.setText(null);
                });
    }

    @Test
    @DisplayName("입력값이 빈 문자열일 때 예외처리 확인")
    void checkEmptyString() {
        StringCalculator calculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.setText("");
                });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외처리 확인")
    void checkOperator() {
        StringCalculator calculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.setText("1 + 2 & 3 & 9");
                });
    }

    @ParameterizedTest
    @CsvSource({"2 + 4 * 2,12", "4 - 2 * 3 * 2 / 3 + 10 - 23,-9", "100 - 50 / 40 * 12 + 35,47"})
    @DisplayName("사칙 연산 모두 확인")
    void calculate(String input, int expected) {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        calculator.setText(input);
        int result = calculator.calculate();

        // then
        assertThat(result).isEqualTo(expected);
    }
}