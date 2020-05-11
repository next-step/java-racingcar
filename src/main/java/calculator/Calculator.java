package calculator;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final int STEP_FOR_CALCULATOR = 2;
    private static final int INITIAL_FIRST_INDEX_FOR_CALCULATOR = 0;
    private static final int INITIAL_OPERATOR_FOR_CALCULATOR = 1;
    private static final int INCREMENT_SECOND_INDEX_NUMBER_FOR_CALCULATOR = 1;
    private static final int ZERO_NUMBER = 0;

    static int add(int startNumber, int endNumber) {
        return startNumber + endNumber;
    }

    static int subtract(int startNumber, int endNumber) {
        return startNumber - endNumber;
    }

    static int divide(int startNumber, int endNumber) {
        checkZeroDivide(endNumber);
        return startNumber / endNumber;
    }

    static int multiple(int startNumber, int endNumber) {
        return startNumber * endNumber;
    }

    static boolean isOperator(String operation) {
        return operation.matches("[\\*\\+-/]");
    }

    static void checkOperationSign(String operation) {
        if (!isOperator(operation)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 사칙연산부호를 입력해주세요.");
        }
    }

    static void checkZeroDivide(int endNumber) {
        if (endNumber == ZERO_NUMBER)
            throw new ArithmeticException("제로로 나누는건 허용되지 않습니다.");
    }

    static void checkBlack(String inputData) {
        if (inputData == null || inputData.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산하기위해 숫자를 입력해주세요.");
        }
    }

    static int runCalculator(String input) {
        checkBlack(input);
        String[] splits = input.split(DELIMITER);

        int totalNumber = convertStringToInt(splits[INITIAL_FIRST_INDEX_FOR_CALCULATOR]);
        for (int i = INITIAL_OPERATOR_FOR_CALCULATOR; i < splits.length; i += STEP_FOR_CALCULATOR) {
            String operation = splits[i];
            checkOperationSign(operation);

            int endNumber = convertStringToInt(splits[i + INCREMENT_SECOND_INDEX_NUMBER_FOR_CALCULATOR]);

            totalNumber = getTotalNumber(totalNumber, operation, endNumber);
        }
        return totalNumber;
    }

    private static int getTotalNumber(int totalNumber, String operation, int endNumber) {
        if ("+".equals(operation)) {
            totalNumber = add(totalNumber, endNumber);
        }
        if ("-".equals(operation)) {
            totalNumber = subtract(totalNumber, endNumber);
        }
        if ("*".equals(operation)) {
            totalNumber = multiple(totalNumber, endNumber);
        }
        if ("/".equals(operation)) {
            totalNumber = divide(totalNumber, endNumber);
        }
        return totalNumber;
    }
}
