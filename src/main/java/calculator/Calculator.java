package calculator;

class Calculator {
    private static final String DELIMITER = " ";
    private static final int FIRST_INDEX_FOR_CALCULATOR = 0;
    private static final int STEP_FOR_CALCULATOR = 2;

    static int add(int startNumber, int endNumber) {
        return startNumber + endNumber;
    }

    static int subtract(int startNumber, int endNumber) {
        return startNumber - endNumber;
    }

    static int divide(int startNumber, int endNumber) {
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

    static void isBlack(String inputData) {
        if (inputData == null || inputData.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    static int stringConvertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산하기위해 숫자를 입력해주세요.");
        }
    }

    static int runCalculator(String input) {
        isBlack(input);
        String[] splits = input.split(DELIMITER);

        int totalNumber = stringConvertToInt(splits[FIRST_INDEX_FOR_CALCULATOR]);
        for (int i = 1; i < splits.length; i += STEP_FOR_CALCULATOR) {
            String operation = splits[i];
            checkOperationSign(operation);

            int endNumber = stringConvertToInt(splits[i + 1]);

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
