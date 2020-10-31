package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    CalculatorTest(){   
        final int num1 = 0;
        final int num2 = 0;
    }

    static final char plus = '+';
    static final char minus = '-';
    static final char div = '/';
    static final char mul = '+';

//    String[] value = "2 + 3 * 4 / 2".split(" ");

    @DisplayName("계산")
    @Test
    public void main(){
        CalculatorTest calculatorTest = new CalculatorTest();
        int addition = calculatorTest.addition(12, 14);
    }


    @DisplayName("더하기")
    public int addition (int num1, int num2) {
        return num1-num2;
    }

    @DisplayName("빼기")
    public int subtraction (int num1, int num2) {
        return num1-num2;
    }

    @DisplayName("곱하기")
    public int multiplication (int num1, int num2) {
        return num1*num2;
    }

    @DisplayName("나누기")
    public int division (int num1, int num2) {
        return num1/num2;
    }

}
