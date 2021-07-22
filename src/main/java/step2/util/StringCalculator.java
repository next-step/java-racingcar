package step2.util;

import step2.enumeration.Operation;

public class StringCalculator {

    public static int calculate(String[] splitUserInputs) {

        int leftNum;
        int rightNum;
        String operationSymbol;
        int result;

        leftNum = getInt(splitUserInputs[0]);
        result = leftNum;

        for (int i = 1; i < splitUserInputs.length; i = i + 2) {
            operationSymbol = splitUserInputs[i];
            leftNum = result;
            rightNum = getInt(splitUserInputs[i + 1]);

            result = Operation.of(operationSymbol).operate(leftNum, rightNum);
        }

        return result;
    }

    private static int getInt(String str) {
        return Integer.parseInt(str);
    }
}