package calculator;

import static calculator.CalculatorSign.*;

public class Calculator {

    public static int calculate(int result, int number, String sign) {
        if(sign.equals("+")) {
            return SUM.calculate(result,number);
        }
        if(sign.equals("*")) {
            return MULTIPLY.calculate(result,number);
        }
        if(sign.equals("-")) {
            return MINUS.calculate(result,number);
        }
        if(sign.equals("/")) {
            return DIVIDE.calculate(result,number);
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
