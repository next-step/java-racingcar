package calculator;

public class Calculator {

    private int result;

    public Calculator() {
        result = 0;
    }

    private String[] getInputArray(String inputStr) {
        Validator.checkInputValidation(inputStr);
        return inputStr.split(" ");
    }

    public int calculate(String inputStr) {
        String[] operandAndOperatorString = getInputArray(inputStr);
        String operator;
        String number1;
        String number2;
        for (int i = 0; i < operandAndOperatorString.length - 2; i += 2) {
            operator = operandAndOperatorString[i + 1];
            number1 = i == 0 ? operandAndOperatorString[i] : Integer.toString(result);
            number2 = operandAndOperatorString[i + 2];

            calculateInOrderUsing(operator, number1, number2);
        }
        return result;
    }

    private void calculateInOrderUsing(String operator, String number1, String number2) {
        Validator.checkCalculateValidation(operator, number1, number2);

        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);

        if ("+".equals(operator)) {
            result = plus(num1, num2);
        }
        if ("-".equals(operator)) {
            result = minus(num1, num2);
        }
        if ("*".equals(operator)) {
            result = multiplication(num1, num2);
        }
        if ("/".equals(operator)) {
            result = devision(num1, num2);
        }
    }

    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public int devision(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로는 연산이 불가합니다.");
        }
        return num1 / num2;
    }
}
