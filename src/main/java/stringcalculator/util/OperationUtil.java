package stringcalculator.util;

import stringcalculator.enumeration.Operation;

public class OperationUtil {

    public static int calculate(String userInput) {
        // 빈 공백 문자열 단위로 분할하기.
        String[] userInputArr = userInput.split(" ");

        int leftNum;
        int rightNum;
        String operatorStr;
        int result;

        leftNum = getInt(userInputArr[0]);
        result = leftNum;

        for (int i = 1; i < userInputArr.length; i = i + 2) {
            operatorStr = userInputArr[i];
            leftNum = result;
            rightNum = getInt(userInputArr[i + 1]);

            result = Operation.of(operatorStr).operate(leftNum, rightNum);

        }

        return result;
    }

    private static int getInt(String str) {
        return Integer.parseInt(str);
    }

}