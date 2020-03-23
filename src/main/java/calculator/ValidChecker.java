package calculator;

import java.util.Objects;

public class ValidChecker {

    private static final String EXCEPTION_MSG_NULL_INPUT = "문자열을 입력해 주세요!";
    private static final String EXCEPTION_MSG_EMPTY_INPUT = "사칙연산을 위한 문자열에는 3개 이상의 인자가 필요합니다!";
    private static final String EXCEPTION_MSG_INVALID_OPERATION = "잘못된 연산자를 입력하였습니다!";
    private static final String EXCEPTION_MSG_INVALID_OPERAND = "피연산자는 숫자여야 합니다!";

    public static void checkValidInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(EXCEPTION_MSG_NULL_INPUT);
        }
    }
    
    public static void checkInputCountComputable(String[] inputs) {
        // 연산을 하기 위해서는 3개 이상의 인자가 필요하고, 홀수개여야 한다.
        if (inputs.length < 3 || inputs.length % 2 == 0) {
            throw new IllegalArgumentException(EXCEPTION_MSG_EMPTY_INPUT);
        } 
    }

    public static void checkValidFormat(String input, boolean isOperation) {
        if (isOperation) {
            checkValidOperation(input);
            return;
        }

        checkValidOperand(input);
    }

    public static void checkValidOperation(String operation) {
        if (!Operation.isSupportedOperation(operation)) {
            throw new IllegalArgumentException(EXCEPTION_MSG_INVALID_OPERATION);
        }
    }

    public static void checkValidOperand(String operand) {
        try {
            Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MSG_INVALID_OPERAND);
        }
    }
}
