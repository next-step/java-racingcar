package calculator.operator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        public int operate(int number, int otherNumber) {
            return number + otherNumber;
        }
    },
    MINUS("-") {
        public int operate(int number, int otherNumber) {
            return number - otherNumber;
        }
    },
    MULTIPLE("*") {
        public int operate(int number, int otherNumber) {
            return number * otherNumber;
        }
    },
    DIVIDE("/") {
        public int operate(int number, int otherNumber) {
            if (number == 0 || otherNumber == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return number / otherNumber;
        }
    };

    private String value;

    Operator(String value) {
        this.value = value;
    }

    public static boolean isOperator(final String value) {
        return PLUS.value.equals(value) || MINUS.value.equals(value) || MULTIPLE.value.equals(value) || DIVIDE.value.equals(value);
    }

    public static Operator getOperator(String operatorText) {
        return Arrays.stream(Operator.values())
                     .filter(operator -> operator.value.equals(operatorText))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("사칙 연산자가 아닙니다."));
    }

    public abstract int operate(int number, int otherNumber);
}
