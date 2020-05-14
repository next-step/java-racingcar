package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @BeforeEach
    void Calculator(){

    }

    //  덧셈
    @Test
    int add(int operand1, int operand2){
       return operand1 + operand2;
    }

    @Test
    //  뺄셈
    int sub(int operand1, int operand2){
        return operand1 - operand2;
    }

    @Test
    //  곱셈
    int mutiple(int operand1, int operand2){
        return operand1 * operand2;
    }

    @Test
    //  나눗셈
    int divide(int operand1, int operand2){
        return operand1 / operand2;
    }

    @Test
    //  입력값이 null이거나 빈 공백 문자일 경우
    void IsNullOrEmptyString(){

    }

    @Test
    //  사칙연산 기호가 아닌경우
    void isNotOperation(){

    }

    @Test
    //  사칙연산을 모두 포함하는 기능 구현
    void calculation(){

    }


}
