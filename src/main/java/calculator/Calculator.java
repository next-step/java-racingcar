package calculator;

class Calculator {
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
}
