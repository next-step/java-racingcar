package stringcalculator.util;

public class OperationUtil {

    public static int calculate(String userInput) {
        // 빈 공백 문자열 단위로 분할하기.
        String[] userInputArr = userInput.split(" ");

        int leftNum = getInt(userInputArr[0]);
        String operator = userInputArr[1];
        int rightNum = getInt(userInputArr[2]);

        int result = OperationUtil.operate(leftNum, operator, rightNum);

        for (int i = 3; i < userInputArr.length; i = i + 2) {

            operator = userInputArr[i];
            rightNum = Integer.parseInt(userInputArr[i + 1]);

            result = OperationUtil.operate(result, operator, rightNum);
        }
        return result;
    }

    private static int getInt(String str) {
        return Integer.parseInt(str);
    }


    public static int operate(int leftNum, String operator, int rightNum) {

        switch (operator) {
            case "+":
                return add(leftNum, rightNum);
            case "-":
                return subtract(leftNum, rightNum);
            case "*":
                return multiply(leftNum, rightNum);
            case "/":
                return divide(leftNum, rightNum);
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }


    private static int add(int leftNum, int rightNum) {
        return leftNum + rightNum;
    }

    private static int subtract(int leftNum, int rightNum) {
        return leftNum - rightNum;
    }

    private static int multiply(int leftNum, int rightNum) {
        return leftNum * rightNum;
    }

    private static int divide(int leftNum, int rightNum) {
        return leftNum / rightNum;
    }


}