package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntNumberTest {

    @DisplayName("문자 혹은 int로 Number를 생성 후, int로 다시 꺼내서 같은 값인지 비교")
    @ParameterizedTest
    @CsvSource(value = { "1:1:1", "-1:-1:-1" }, delimiter = ':')
    void createNumber(String stringNumber, int intNumber, int expected) {
        IntNumber numberFromString = new IntNumber(stringNumber);
        IntNumber numberFromInt = new IntNumber(intNumber);

        assertThat(numberFromString.value()).isEqualTo(expected);
        assertThat(numberFromInt.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 덧셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:3", "-1:2:1", "-1:-2:-3" }, delimiter = ':')
    void plus(int firstOperand, int secondOperand, int expected) {
        IntNumber result = new IntNumber(firstOperand).plus(new IntNumber(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 뺄셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:-1", "-1:2:-3", "-3:-3:0" }, delimiter = ':')
    void minus(int firstOperand, int secondOperand, int expected) {
        IntNumber result = new IntNumber(firstOperand).minus(new IntNumber(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 곱셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:2", "-1:2:-2", "-3:-2:6" }, delimiter = ':')
    void times(int firstOperand, int secondOperand, int expected) {
        IntNumber result = new IntNumber(firstOperand).times(new IntNumber(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 나눗셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "4:2:2", "-2:2:-1", "-9:-3:3" }, delimiter = ':')
    void devidedBy(int firstOperand, int secondOperand, int expected) {
        IntNumber result = new IntNumber(firstOperand).divide(new IntNumber(secondOperand));
        assertThat(result.value()).isEqualTo(expected);
    }
}
