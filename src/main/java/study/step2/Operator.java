package study.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }


    static boolean isOperator(String str) {
        return Arrays.stream(Operator.values()).anyMatch(v -> v.operator.equals(str));
    }

    int calculate(int firstNum, int secondNum) {

        int result = 0;

        if (operator.equals(Operator.PLUS.operator)) {
            return firstNum + secondNum;
        }

        if (operator.equals(Operator.MINUS.operator)) {
            return firstNum - secondNum;
        }

        if (operator.equals(Operator.MULTIPLICATION.operator)) {
            return firstNum * secondNum;
        }

        if (operator.equals(Operator.DIVISION.operator)) {
            return firstNum / secondNum;
        }

        return result;
    }

    static Operator valueOfStr(String str) {
        return Arrays.stream(Operator.values())
                .filter(v -> v.operator.equals(str))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
