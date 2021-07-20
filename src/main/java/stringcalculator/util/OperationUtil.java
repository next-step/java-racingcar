package stringcalculator.util;

public class OperationUtil {

    public static int calculate(String userInput) {
        // 빈 공백 문자열 단위로 분할하기.
        String[] userInputArr = userInput.split(" ");

        int num1 = Integer.parseInt(userInputArr[0]);
        String operator = userInputArr[1];
        int num2 = Integer.parseInt(userInputArr[2]);

        int result = OperationUtil.operate(num1, operator, num2);

        for (int i = 3; i < userInputArr.length; i = i + 2) {

            operator = userInputArr[i];
            num2 = Integer.parseInt(userInputArr[i + 1]);

            result = OperationUtil.operate(result, operator, num2);
        }
        return result;
    }


    public static int operate(int num1, String operator, int num2) {

        switch (operator) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }


    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    private static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private static int divide(int num1, int num2) {
        return num1 / num2;
    }


}