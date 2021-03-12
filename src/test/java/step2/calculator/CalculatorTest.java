package step2.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator;
    private Util util;


    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }


    @ParameterizedTest
    @CsvSource(value = {"3, 3", "4, 4", "5, 5"})
    void checkOperand(String operandStr, int operand){
        assertThat(Util.checkOperand(operandStr)).isEqualTo(operand);
    }

    @ParameterizedTest
    @CsvSource(value = {"a", "?", "%", "B", "/"})
    void validateIllegalOperand(String input){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->{
                    Util.checkOperand(input);
                }).withMessageMatching("피연산자가 잘못되었습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateInputEmpty(String input){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Util.checkEmpty(input);
                }).withMessageMatching("input 값은 비어있을 수 없습니다.");
    }


    @ParameterizedTest
    @CsvSource({"1 + 2 / 3, 1", "3 * 4 / 3, 4"})
    void validateOperation(String input, int result){
        assertThat(calculator.calculate(input)).isEqualTo(result);
    }
}
