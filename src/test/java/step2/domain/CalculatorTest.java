package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.BlankException;
import step2.exception.NotOperatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator = new Calculator();


    @ParameterizedTest
    @CsvSource(value = {"2 + 3 + 4:" + (2 + 3 + 4), "5 + 6 + 1:" + (5 + 6 + 1)}, delimiter = ':')
    @DisplayName("덧셈을 테스트 한다.")
    void plus(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 3 - 4:" + (2 - 3 - 4), "5 - 6 - 1:" + (5 - 6 - 1)}, delimiter = ':')
    @DisplayName("뺄셈을 테스트 한다.")
    void minus(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 3 * 4:" + (2 * 3 * 4), "5 * 6 * 1:" + (5 * 6 * 1)}, delimiter = ':')
    @DisplayName("곱셈을 테스트 한다.")
    void multiply(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 / 3 / 4:" + (2 / 3 / 4), "5 / 6 / 1:" + (5 / 6 / 1)}, delimiter = ':')
    @DisplayName("나눗셈을 테스트 한다.")
    void division(String input, int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:" + (10), "2 + 3 * 4 / 2:" + (10)}, delimiter = ':')
    @DisplayName("혼합된 연산자를 테스트 한다.")
    void mixedOperator(String input, int expected) {

        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }


    @Test
    @DisplayName("입력값이 빈 공백 문자열일 경우 IllegalArgumentException throw를 반환한다.")
    void isBlankStringThrowIllegalArgumentException() {
        assertThatThrownBy( () -> calculator.calculate(" ")).isInstanceOf(BlankException.class);
    }

    @Test
    @DisplayName("입력값이 사칙연산이 아닐 경우 IllegalArgumentException throw를 반환한다.")
    void isNotInputValueOperatorThrowIllegalArgumentException() {

        assertThatThrownBy( () -> calculator.calculate("1 : 2")).isInstanceOf(NotOperatorException.class);
    }
}