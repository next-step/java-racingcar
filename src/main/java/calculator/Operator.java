package calculator;

import java.util.function.BinaryOperator;

public enum Operator {

    ADDITION((x, y) -> x + y),
    SUBTRACTION((x, y) -> x - y),
    MULTIPLICATION((x, y) -> x * y),
    DIVISION((x, y) -> x / y);

    BinaryOperator<Integer> calculation;

    Operator(BinaryOperator<Integer> calculation) {
        this.calculation = calculation;
    }

    public static Operator createOperator(String str) {
        switch (str) {
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "*":
                return MULTIPLICATION;
            case "/":
                return DIVISION;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다. 사칙 연산자를 사용해주세요.");
        }
    }

}
