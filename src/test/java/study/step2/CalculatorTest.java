package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @ParameterizedTest(name = "PLUS 테스트")
    @CsvSource(value = {"3,5,8", "2,3,5", "5,5,10"}, delimiter = ',')
    void plus(int number1, int number2, int expected){
        String operator = "+";
        assertThat(Calculator.operate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "MINUS 테스트")
    @CsvSource(value = {"3,5,-2", "5,3,2", "5,5,0"}, delimiter = ',')
    void minus(int number1, int number2, int expected){
        String operator = "-";
        assertThat(Calculator.operate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "MULTIPLE 테스트")
    @CsvSource(value = {"3,5,15", "2,3,6", "5,5,25"}, delimiter = ',')
    void multiple(int number1, int number2, int expected){
        String operator = "*";
        assertThat(Calculator.operate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "DIVIDE 테스트")
    @CsvSource(value = {"5,3,1", "2,3,0", "5,5,1"}, delimiter = ',')
    void divide(int number1, int number2, int expected){
        String operator = "/";
        assertThat(Calculator.operate(operator, number1, number2)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "연산기호 유효성 테스트")
    @ValueSource(strings = {"^", "$", " "})
    void operateException(String operator) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Calculator.operate(operator, 1, 2));
    }

}

