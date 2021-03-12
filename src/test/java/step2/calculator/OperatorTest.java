package step2.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorTest {

    private Operator addOperator;
    private Operator minusOperator;
    private Operator multiplyOperator;
    private Operator divideOperator;

    private static final String NUMBER1 = "2, 3";
    private static final String NUMBER2 = "-1, 5";
    private static final String NUMBER3 = "-1, -3";
    private static final String NUMBER4 = "3, -1";

    @BeforeEach
    void setUp(){
        addOperator = Operator.validate("+");
        minusOperator = Operator.validate("-");
        multiplyOperator = Operator.validate("*");
        divideOperator = Operator.validate("/");
    }


    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void addTest(int num1, int num2){
        assertThat(addOperator.operate(num1, num2)).isEqualTo(num1 + num2);
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void minusTest(int num1, int num2){
        assertThat(minusOperator.operate(num1, num2)).isEqualTo(num1 - num2);
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void multiplyTest(int num1, int num2){
        assertThat(multiplyOperator.operate(num1, num2)).isEqualTo(num1 * num2);
    }

    @ParameterizedTest
    @CsvSource(value = {NUMBER1, NUMBER2, NUMBER3, NUMBER4})
    void divideTest(int num1, int num2){
        assertThat(divideOperator.operate(num1, num2)).isEqualTo(num1 / num2);
    }


    @ParameterizedTest
    @CsvSource(value = {"?", "&", "^"})
    void validateFalseOperator(String operator){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->{
                    Operator.validate(operator);
                }).withMessageMatching("잘못된 연산기호입니다.");
    }

    @Test
    void OperatorTesst(){
        Operator test = Operator.validate("+");
        System.out.println(test);
        int num = test.operate(1, 3);
        System.out.println(num);
    }

}
