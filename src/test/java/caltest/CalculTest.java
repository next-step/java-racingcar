package caltest;

import calculator.Calculator;
import calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculTest {

    Calculator calculator = new Calculator("2 + 6 / 3 * 4");

    @DisplayName("operator plus 연산 테스트")
    @Test
    void operatorPlusTest(){
        int result = Operator.PLUS.operate(1,5);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("operator minus 연산 테스트")
    @Test
    void operatorMinusTest(){
        int result = Operator.MINUS.operate(7,3);
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("operator multiply 연산 테스트")
    @Test
    void operatorMultiplyTest(){
        int result = Operator.MULTIPLY.operate(3,4);
        assertThat(result).isEqualTo(12);
    }

    @DisplayName("operator divide 연산 테스트")
    @Test
    void operatorDivideTest(){
        int result = Operator.DIVIDE.operate(12,4);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("operator divide 0으로 나눴을때 테스트")
    @Test
    void operatorDivideZeroTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.DIVIDE.operate(8,0);
        });
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void inputNullOrEmptyTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator("");
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.createOperator("2 ( 3");
        });
    }

}
