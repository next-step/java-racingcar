package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @DisplayName("덧셈 : 10과 15의 덧셈 결과는 25를 반환한다")
    @Test
    public void add_calculateTest() {
        //given
        int number1 = 10;
        int number2 = 15;
        String operator = "+";
        int expectedValue = 25;

        //when
        Calculator calculator = new Calculator(number1);

        //then
        assertThat(calculator.calculate(operator, number2)).isEqualTo(expectedValue);
    }

    @DisplayName("뺄셈 : 31과 15의 뺄셈 결과는 16을 반환한다")
    @Test
    public void subtract_calculateTest() {
        //given
        int number1 = 31;
        int number2 = 15;
        String operator = "-";
        int expectedValue = 16;

        //when
        Calculator calculator = new Calculator(number1);

        //then
        assertThat(calculator.calculate(operator, number2)).isEqualTo(expectedValue);
    }

    @DisplayName("곱셈 : 11과 16의 곱셈 결과는 176을 반환한다")
    @Test
    public void multiply_calculateTest() {
        //given
        int number1 = 11;
        int number2 = 16;
        String operator = "*";
        int expectedValue = 176;

        //when
        Calculator calculator = new Calculator(number1);

        //then
        assertThat(calculator.calculate(operator, number2)).isEqualTo(expectedValue);
    }

    @DisplayName("나눗셈 : 8와 2의 나눗셈 결과는 4를 반환한다")
    @Test
    public void divide_calculateTest() {
        //given
        int number1 = 8;
        int number2 = 2;
        String operator = "/";
        int expectedValue = 4;

        //when
        Calculator calculator = new Calculator(number1);

        //then
        assertThat(calculator.calculate(operator, number2)).isEqualTo(expectedValue);
    }

}
