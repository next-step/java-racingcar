package calculator;

import java.util.function.BinaryOperator;

public enum Operator {
    ADD("+", (firstNum, secondNum) -> firstNum + secondNum),
    SUBTRACT("-", (firstNum, secondNum) -> firstNum - secondNum),
    MULTIPLY("*", (firstNum, secondNum) -> firstNum * secondNum),
    DIVIDE("/", (firstNum, secondNum) -> firstNum / secondNum);

    private BinaryOperator<Integer> expressions;
    private String looks;

    Operator(String looks, BinaryOperator<Integer> expressions) {
        this.looks = looks;
        this.expressions = expressions;
    }

    public static Operator looksOf(String looks) {
        for (Operator operator : Operator.values()) {
            if (operator.looks.equals(looks)) {
                return operator;
            }
        }

        throw new IllegalArgumentException();
    }

    public int calculate(int firstNum, int secondNum) {
        return expressions.apply(firstNum, secondNum);
    }
}
