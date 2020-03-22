package calculator;

import java.util.List;
import java.util.Objects;

public class Calculator {
    private static final String INPUT_DELIMITER = " ";

    private static final String EXCEPTION_MSG_NULL_INPUT = "문자열을 입력해 주세요!";
    private static final String EXCEPTION_MSG_EMPTY_INPUT = "사칙연산을 위한 문자열에는 3개 이상의 인자가 필요합니다!";
    private static final String EXCEPTION_MSG_INVALID_OPERATION = "잘못된 연산자를 입력하였습니다!";
    private static final String EXCEPTION_MSG_INVALID_OPERAND = "피연산자는 숫자여야 합니다!";

    public int calculate(String input) {
        checkValidInput(input);
        checkValidInputFormat(input);

        String[] inputs = input.split(INPUT_DELIMITER);
        int result = Integer.parseInt(inputs[0]);
        for (int operationIdx = 1; operationIdx <= inputs.length - 2; operationIdx+=2) {
            result = Operation.getOperationByValue(inputs[operationIdx]).operate(result, Integer.parseInt(inputs[operationIdx + 1]));
        }

        return result;
    }

    public void checkValidInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(EXCEPTION_MSG_NULL_INPUT);
        }

        if (input.split(INPUT_DELIMITER).length < 3) {
            throw new IllegalArgumentException(EXCEPTION_MSG_EMPTY_INPUT);
        }
    }


    public void checkValidInputFormat(String input) {
        int idx = 0;
        for (String string : input.split(INPUT_DELIMITER)) {
            checkValidFormat(string, idx % 2 == 1);
            ++idx;
        }
    }

    private void checkValidFormat(String input, boolean isOperation) {
        if (!isOperation) {
            checkValidOperand(input);
            return;
        }

        if (!Operation.isSupportedOperation(input)) {
            throw new IllegalArgumentException(EXCEPTION_MSG_INVALID_OPERATION);
        }
    }

    private void checkValidOperand(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MSG_INVALID_OPERAND);
        }
    }
}
