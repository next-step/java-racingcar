package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class StringCalculator {

    @Test
    @DisplayName("덧셈 input을 입력하면 결과값을 출력한다.")
    public void 덧셈(){

        Integer result = calculator("1 + 2 + 3");
        System.out.println(result);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("뺄셈 input을 입력하면 결과값을 출력한다.")
    public void 뺼셈(){

        Integer result = calculator("10 - 1 - 4");
        System.out.println(result);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("곱셈 input을 입력하면 결과값을 출력한다.")
    public void 곱셈(){

        Integer result = calculator("2 * 5 * 3");
        System.out.println(result);
        assertThat(result).isEqualTo(30);
    }

    @Test
    @DisplayName("나눗셈 input을 입력하면 결과값을 출력한다.")
    public void 나눗셈(){

        Integer result = calculator("50 / 2 / 5");
        System.out.println(result);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("입력값이 null일 경우 NullPointerException 발생")
    public void nullExceptionTest(){

        assertThatNullPointerException()
                .isThrownBy(()-> {
                    calculator(null);
                });
    }

    @Test
    @DisplayName("입력값이 공백일 경우 IllegalArgumentException 발생")
    public void emptyExceptionTest(){

        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    calculator("");
                });
    }

    @Test
    @DisplayName("사칙연산이 섞인 경우 원하는 값이 나오는지 테스트")
    public void 사칙연산(){

        Integer result = calculator("1 + 4 * 2 / 5 - 1");
        assertThat(result).isEqualTo(1);
    }


    public Integer calculator(String stringExpression){
        validateExression(stringExpression);
        Stack<Integer> operand = new Stack<>();
        Stack<String> operator = new Stack<>();

        prepare(stringExpression,operand,operator);

        while (operand.size() > 1){
            operand.push(calculate(operand.pop(), operator.pop(), operand.pop()));
        }

        return operand.pop();
    }

    public void validateExression(String stringExpression){
        if (stringExpression.isEmpty() || stringExpression == null){
            throw new IllegalArgumentException("입력값은 null이나 공백문자일 수 없습니다.");
        }
    }

    public void prepare(String stringExpression,Stack operand, Stack operator){
        String[] expression = stringExpression.split(" ");
        for (int i = expression.length-1; i >= 0; i--){
            //짝수 일 경우 operand
            if (i % 2 == 0){
                operand.push(Integer.parseInt(expression[i]));
            }
            else {
                operator.push(expression[i]);
            }
        }
    }

    public Integer calculate(Integer operand1,String operator, Integer operand2){
        if (operator.equals("+")){
            return operand1 + operand2;
        }

        if(operator.equals("-")){
            return operand1 - operand2;
        }

        if (operator.equals("*")){
            return operand1*operand2;
        }

        if(operator.equals("/")){
            return operand1/operand2;
        }

        return null;
    }

}
