package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        //given
        int firstOperand = 2;
        int secondOperand = 3;

        //when
        int result = Operator.ADD.calculate(firstOperand, secondOperand);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus() {
        //given
        int firstOperand = 3;
        int secondOperand = 1;

        //when
        int result = Operator.MINUS.calculate(firstOperand, secondOperand);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiple() {
        //given
        int firstOperand = 3;
        int secondOperand = 2;

        //when
        int result = Operator.MULTIPLY.calculate(firstOperand, secondOperand);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        //given
        int firstOperand = 6;
        int secondOperand = 2;

        //when
        int result = Operator.DIVIDE.calculate(firstOperand, secondOperand);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("원하는 연산자를 정확하게 찾는지 테스트한다.")
    void operator_find_test() {
        //given
        String operator = "+";
        Operator expected = Operator.ADD;

        //when
        Operator findOperator = Operator.find(operator);

        //then
        assertThat(findOperator).isEqualTo(expected);

    }
}