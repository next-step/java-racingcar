package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

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

}
