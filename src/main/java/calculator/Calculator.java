package calculator;

public class Calculator {
    private static final String INPUT_DELIMITER = " ";

    public int calculate(String input) {
        ValidChecker.checkValidInput(input);

        String[] inputs = input.split(INPUT_DELIMITER);
        ValidChecker.checkInputCountComputable(inputs);

        int result = Integer.parseInt(inputs[0]);
        int maxOperationIdx = inputs.length - 2;
        checkValidFormatForOperate(inputs, 0);

        for (int operationIdx = 1; operationIdx <= maxOperationIdx; operationIdx += 2) {
            checkValidFormatForOperate(inputs, operationIdx);
            result = Operation.getOperationByValue(inputs[operationIdx]).operate(result, Integer.parseInt(inputs[operationIdx + 1]));
        }

        return result;
    }

    private void checkValidFormatForOperate(String[] inputs, int idx) {
        boolean isOperationIdx = isOperationIdx(idx);
        ValidChecker.checkValidFormat(inputs[idx], isOperationIdx);

        // index 가 연산자의 index 값일 경우 다음에 오는 피연산자의 유효성도 확인 해 주어야 한다.
        if (isOperationIdx) {
            ValidChecker.checkValidFormat(inputs[idx + 1], isOperationIdx(idx + 1));
        }
    }

    public static boolean isOperationIdx(int idx) {
        return idx % 2 == 1;
    }
}
