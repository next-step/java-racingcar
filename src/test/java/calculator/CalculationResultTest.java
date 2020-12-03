package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationResultTest {

    @Test
    @DisplayName("초기 값은 입력 문자열의 첫번째 값을 가짐")
    public void CalculationResultFirstResult() throws Exception {
        //given
        String input = "2 + 3 - 2";

        //when
        CalculationResult result = new CalculationResult(input);

        //then
        Assertions.assertEquals(result.getResult(), 2);
    }
    @Test
    @DisplayName("계산되는 값을 계속 합산하여 가지고 있어야함")
    public void resultSum(){
        //given
        int firstNumber = 3;
        String operator = "+";
        int secondNumber = 5;
        int expect = 2 * (firstNumber + secondNumber);
        CalculationResult result = new CalculationResult(String.valueOf(0));

        //when
        result.set(Operator.getOperator(operator).calculate(firstNumber, secondNumber));
        result.set(Operator.getOperator(operator).calculate(result.getResult(), firstNumber));
        result.set(Operator.getOperator(operator).calculate(result.getResult(), secondNumber));

        //then
        assertThat(result.getResult()).isEqualTo(expect);
    }
}
