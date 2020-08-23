package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    List<Integer> answers = initOperatorTest();
    @DisplayName("plus, minus, multiply, divide 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void operatorTest(String operator){

        assertThat(answers.contains(Operator.findOperator(operator).operate(10, 2))).isTrue();

    }

    @DisplayName("operator plus 연산 테스트")
    @Test
    void operatorPlusTest(){
        int result = Operator.PLUS.operate(1,5);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("operator minus 연산 테스트")
    @Test
    void operatorMinusTest(){
        int result = Operator.MINUS.operate(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("operator multiply 연산 테스트")
    @Test
    void operatorMultiplyTest(){
        int result = Operator.MULTIPLY.operate(10, 2);
        assertThat(result).isEqualTo(20);
    }

    @DisplayName("operator divide 연산 테스트")
    @Test
    void operatorDivideTest(){
        int result = Operator.DIVIDE.operate(100, 10);
        assertThat(result).isEqualTo(10);
    }

    private List<Integer> initOperatorTest(){
        List<Integer> answers = new ArrayList<>();
        answers.add(12);
        answers.add(8);
        answers.add(20);
        answers.add(5);

        return answers;
    }

}
