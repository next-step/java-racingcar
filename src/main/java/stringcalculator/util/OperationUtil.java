package stringcalculator.util;

import stringcalculator.enumeration.Operation;

public class OperationUtil {

    public static int calculate(String userInput) {
        // 빈 공백 문자열 단위로 분할하기.
        String[] userInputArr = userInput.split(" ");

        int leftNum = getInt(userInputArr[0]);
        String operatorStr = userInputArr[1];
        int rightNum = getInt(userInputArr[2]);

        int result = Operation.of(operatorStr).operate(leftNum, rightNum);

        for (int i = 3; i < userInputArr.length; i = i + 2) {

            operatorStr = userInputArr[i];
            rightNum = Integer.parseInt(userInputArr[i + 1]);

            result = Operation.of(operatorStr).operate(result, rightNum);
        }

        return result;
    }

    private static int getInt(String str) {
        return Integer.parseInt(str);
    }

}