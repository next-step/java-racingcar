package stringcalculator.util;

import stringcalculator.enumeration.Operation;

public class OperationUtil {
    
    public static int calculate(String[] userInputArray) {

        int leftNum;
        int rightNum;
        String operatorStr;
        int result;

        leftNum = getInt(userInputArray[0]);
        result = leftNum;

        for (int i = 1; i < userInputArray.length; i = i + 2) {
            operatorStr = userInputArray[i];
            leftNum = result;
            rightNum = getInt(userInputArray[i + 1]);

            result = Operation.of(operatorStr).operate(leftNum, rightNum);
        }

        return result;
    }

    private static int getInt(String str) {
        return Integer.parseInt(str);
    }

}