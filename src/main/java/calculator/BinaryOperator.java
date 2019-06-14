package calculator;

import java.util.Arrays;

public enum BinaryOperator implements Operable {
    ADDITION("+") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private String operatorNotation;

    BinaryOperator(String operatorNotation) {
        this.operatorNotation = operatorNotation;
    }

    public static BinaryOperator of(String operatorNotation) {
        return Arrays.stream(BinaryOperator.values())
                .filter(operator -> operator.operatorNotation.equals(operatorNotation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}
