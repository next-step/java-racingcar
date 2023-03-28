package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+") {
        @Override
        int excute(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUBSTRACT("-") {
        @Override
        int excute(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*") {
        @Override
        int excute(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        @Override
        int excute(int num1, int num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    abstract int excute(int num1, int num2);

    public static int calculate(int num1, int num2, String operator) {
        return Arrays.stream(values())
            .filter(operators -> operators.operator.equals(operator))
            .findAny()
            .map(operators -> operators.excute(num1, num2))
            .orElseThrow(IllegalArgumentException::new);
    }
}
