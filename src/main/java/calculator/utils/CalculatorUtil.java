package calculator.utils;

public class CalculatorUtil {

    public static int calculate(String operator, int operand1, int operand2) {

        int result = 0;

        if (operator.equals("+")) {
            result = operand1 + operand2;
        }
        if (operator.equals("*")) {
            result = operand1 * operand2;
        }
        if (operator.equals("-")) {
            result = operand1 - operand2;
        }
        if (operator.equals("/")) {
            if(operand2 == 0){
                throw new IllegalArgumentException("나눗셈은 0으로 연산할 수 없습니다.");
            }
            result = operand1 / operand2;
        }

        return result;

    }

}
