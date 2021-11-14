package study.calculate;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @DisplayName("숫자가 아닌 문자열을 생성자로 받을 경우 exception을 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = { "a", "c", "test" })
    void createWithInvalidNumber(String stringNumber) {
        assertThatThrownBy(() -> new Number(stringNumber)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자 혹은 int로 Number를 생성 후, int로 다시 꺼내서 같은 값인지 비교")
    @ParameterizedTest
    @CsvSource(value = { "1:1:1", "-1:-1:-1" }, delimiter = ':')
    void createNumber(String stringNumber, int intNumber, int expected) {
        Number numberFromString = new Number(stringNumber);
        Number numberFromInt = new Number(intNumber);

        assertThat(numberFromString.value()).isEqualTo(expected);
        assertThat(numberFromInt.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 덧셈 기능 정상동작 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:3", "-1:2:1", "-1:-2:-3" }, delimiter = ':')
    void plus(int firstOperand, int secondOperand, int expected) {
        Number result = new Number(firstOperand).plus(new Number(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 뺄셈 기능 정상동작 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:-1", "-1:2:-3", "-3:-3:0" }, delimiter = ':')
    void minus(int firstOperand, int secondOperand, int expected) {
        Number result = new Number(firstOperand).minus(new Number(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 곱셈 기능 정상동작 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:2", "-1:2:-2", "-3:-2:6" }, delimiter = ':')
    void times(int firstOperand, int secondOperand, int expected) {
        Number result = new Number(firstOperand).times(new Number(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 나눗셈 기능 정상동작 테스트")
    @ParameterizedTest
    @CsvSource(value = { "4:2:2", "-2:2:-1", "-9:-3:3" }, delimiter = ':')
    void devidedBy(int firstOperand, int secondOperand, int expected) {
        Number result = new Number(firstOperand).divide(new Number(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("0으로 나눴을 때 예외를 던진다")
    @ParameterizedTest
    @CsvSource(value = { "4:0", "-2:0", "-9:0" }, delimiter = ':')
    void divideByZero(int firstOperand, int secondOperand) {
        assertThatThrownBy(() -> new Number(firstOperand).divide(new Number(secondOperand))).isInstanceOf(RuntimeException.class);
    }
}
