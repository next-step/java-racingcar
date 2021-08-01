package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


@DisplayName("사칙연산 테스트")
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("덧셈")
    @ParameterizedTest(name="{0} = {1}")
    @CsvSource(value = {"1 + 2:3", "2 + 3:5"}, delimiter = ':')
    void add(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest(name="{0} = {1}")
    @CsvSource(value = {"1 - 2:-1", "3 - 2:1"}, delimiter = ':')
    void subtract(String input, int expected) {
       assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("곱셈")
    @ParameterizedTest(name="{0} = {1}")
    @CsvSource(value = {"1 * 2:2", "3 * 2:6"}, delimiter = ':')
    void multiply(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest(name="{0} = {1}")
    @CsvSource(value = {"2 / 2:1", "6 / 2 :3"}, delimiter = ':')
    void divide(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }


    @DisplayName("나눗셈:0으로 나누면 에러남")
    @Test
    void divideByZeroThrowsException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.calculate("1 / 0")).withMessageMatching("나눗셈의 제수는 0이 올 수 없습니다.");
    }

    @DisplayName("사칙연산 전체: 3 + 5 - 2 * 2 / 3 = 4")
    @Test
    void calculateUsing4Operators() {
        assertThat(calculator.calculate("3 + 5 - 2 * 2 / 3")).isEqualTo(4);
    }


}
