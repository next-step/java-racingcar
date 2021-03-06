import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator;

    private static final String NUMBER1 = "2, 3";
    private static final String NUMBER2 = "-1, 5";
    private static final String NUMBER3 = "-1, -3";
    private static final String NUMBER4 = "3, -1";


    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void addTest(int num1, int num2){
        assertThat(calculator.add(num1, num2)).isEqualTo(num1 + num2);
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void minusTest(int num1, int num2){
        assertThat(calculator.minus(num1, num2)).isEqualTo(num1 - num2);
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void multiplyTest(int num1, int num2){
        assertThat(calculator.multiply(num1, num2)).isEqualTo(num1 * num2);
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void divideTest(int num1, int num2){
        assertThat(calculator.divide(num1, num2)).isEqualTo(num1 / num2);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 3", "4, 4", "5, 5"})
    void checkOperand(String operandStr, int operand){
        assertThat(calculator.checkOperand(operandStr)).isEqualTo(operand);
    }

    @ParameterizedTest
    @CsvSource(value = {"a", "?", "%", "B", "/"})
    void validateIllegalOperand(String input){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->{
                    calculator.checkOperand(input);
                }).withMessageMatching("피연산자가 잘못되었습니다.");
    }


    @ParameterizedTest
    @NullAndEmptySource
    void validateInputEmpty(String input){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(input);
                }).withMessageMatching("input 값은 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"?", "&", "^"})
    void validateFalseOperator(String operator){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->{
                    calculator.checkOperate(operator);
                }).withMessageMatching("잘못된 연산기호입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1, +, 2, 3", "2, -, 3, -1", "2, *, 3, 6", "3, /, 2, 1"})
    void oneCalculate(int num1, String operator, int num2, int answer){
        assertThat(calculator.operate(operator, num1, num2)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({"1 + 2 / 3, 1", "3 * 4 / 3, 4"})
    void validateOperation(String input, int result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }
}
