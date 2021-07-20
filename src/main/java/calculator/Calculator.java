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
        String[] inputArr = getInputArray(inputStr);
        String operator, number1, number2;
        for (int i = 0; i < inputArr.length - 2; i += 2) {
            operator = inputArr[i + 1];
            number1 = inputArr[i];
            number2 = inputArr[i + 2];
            Validator.checkCalculateValidation(operator, number1, number2);

            result = i == 0 ? Integer.parseInt(number1) : result;
            calculateResult(operator, result, Integer.parseInt(number2));
        }

        return result;
    }

    private void calculateResult(String operator, int num1, int num2) {
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
        if (num1 == 0 || num2 == 0) {
            throw new ArithmeticException("0으로는 연산이 불가합니다.");
        }
        return num1 / num2;
    }
}
