package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("정상 입력시 의도대로 계산된 값이 나오는지 테스트")
    @Test
    void calculateTest(){
        String[] formula = new Formula("5 + 5 * 5 / 25").splitFormula();
        int result = calculator.calculateFormula(formula);
        assertThat(2).isEqualTo(result);
    }

    @DisplayName("0 으로 나눌 시 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void divideZeroTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] formula = new Formula("2 + 2 * 10 / 0").splitFormula();
            calculator.calculateFormula(formula);
        });
    }


    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생 하는지 테스트")
    @Test
    void inputNullOrEmptyTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] formula = new Formula("2 +   * 2 / 2").splitFormula();
            calculator.calculateFormula(formula);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @Test
    void checkPermittedOperator(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] formula = new Formula("2 $ 6 * 5 / 4").splitFormula();
            calculator.calculateFormula(formula);
        });
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

}