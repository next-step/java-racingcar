import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

//    private static final String[] numbers = {"2, 3", "-1, 5", "-1, -3", "3, -1"};
//    왜 String[]을 @CsvSource 안에 넣으면 constant가 아니라고 오류가 나는것일까요?

    private static final String number1 = "2, 3";
    private static final String number2 = "-1, 5";
    private static final String number3 = "-1, -3";
    private static final String number4 = "3, -1";


    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {number1, number2, number3, number4})
    void addTest(int num1, int num2){
        assertThat(calculator.add(num1, num2)).isEqualTo(num1 + num2);
    }

    @ParameterizedTest
    @CsvSource(value = {number1, number2, number3, number4})
    void minusTest(int num1, int num2){
        assertThat(calculator.minus(num1, num2)).isEqualTo(num1 - num2);
    }

    @ParameterizedTest
    @CsvSource(value = {number1, number2, number3, number4})
    void multiplyTest(int num1, int num2){
        assertThat(calculator.multiply(num1, num2)).isEqualTo(num1 * num2);
    }

    @ParameterizedTest
    @CsvSource(value = {number1, number2, number3, number4})
    void divideTest(int num1, int num2){
        assertThat(calculator.divide(num1, num2)).isEqualTo(num1 / num2);
    }


}
