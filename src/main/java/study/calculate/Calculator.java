package study.calculate;

public class Calculator {

    private Calculator() {
        new AssertionError();
    }

    public static int calculate(Expression expression) {
        Number result = new Number(expression.next());
        while (!expression.isEmpty()) {
            Operator operator = Operator.findBy(expression.next());
            Number operand = new Number(expression.next());

            result = operator.operate(result, operand);
        }
        return result.value();
    }
}
