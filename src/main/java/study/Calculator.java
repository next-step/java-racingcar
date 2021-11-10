package study;

import study.operator.Operator;

public class Calculator {

    private Calculator() {
        new AssertionError();
    }

    public static int calculate(Expression expression) {
        int result = Integer.parseInt(expression.next());
        while (!expression.isEmpty()) {
            Operator operator = Operator.findBy(expression.next());
            int operand = Integer.parseInt(expression.next());

            result = operator.operate(result, operand);
        }
        return result;
    }
}
