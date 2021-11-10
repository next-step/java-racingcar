package study;

import study.operator.Operator;

public class Calculator {

    private Calculator() {
        new AssertionError();
    }

    public static int calculate(Expression expression) {
        IntNumber result = new IntNumber(expression.next());
        while (!expression.isEmpty()) {
            Operator operator = Operator.findBy(expression.next());
            IntNumber operand = new IntNumber(expression.next());

            result = operator.operate(result, operand);
        }
        return result.value();
    }
}
