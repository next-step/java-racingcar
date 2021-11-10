package study.operator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

    @DisplayName("피연산자 2개가 주어졌을 때 덧셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:3", "-1:2:1", "-1:-2:-3" }, delimiter = ':')
    void plus(int firstOperand, int secondOperand, int expected) {
        int result = Operator.PLUS.operate(firstOperand, secondOperand);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 뺄셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:-1", "-1:2:-3", "-3:-3:0" }, delimiter = ':')
    void minus(int firstOperand, int secondOperand, int expected) {
        int result = Operator.MINUS.operate(firstOperand, secondOperand);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 곱셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1:2:2", "-1:2:-2", "-3:-2:6" }, delimiter = ':')
    void times(int firstOperand, int secondOperand, int expected) {
        int result = Operator.TIMES.operate(firstOperand, secondOperand);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("피연산자 2개가 주어졌을 때 나눗셈 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = { "4:2:2", "-2:2:-1", "-9:-3:3" }, delimiter = ':')
    void devidedBy(int firstOperand, int secondOperand, int expected) {
        int result = Operator.DIVIDE.operate(firstOperand, secondOperand);
        assertThat(result).isEqualTo(expected);
    }
}
