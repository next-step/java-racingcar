package calculator;

import java.util.function.BinaryOperator;

public enum Calculator {
    ADD("+", (firstNum, secondNum) -> firstNum + secondNum),
    SUBTRACT("-", (firstNum, secondNum) -> firstNum - secondNum),
    MULTIPLY("*", (firstNum, secondNum) -> firstNum * secondNum),
    DIVIDE("/", (firstNum, secondNum) -> firstNum / secondNum);

    private BinaryOperator<Integer> expressions;
    private String looks;

    Calculator(String looks, BinaryOperator<Integer> expressions) {
        this.looks = looks;
        this.expressions = expressions;
    }

    public int calculate(int firstNum, int secondNum) {
        return expressions.apply(firstNum, secondNum);
    }
}
