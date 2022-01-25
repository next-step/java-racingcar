package calculator.domain;

public class Calculator {

    private Expression expression;

    private Calculator() {}

    public Calculator(Expression expression) {
        this.expression = expression;
    }

    public static long add(long num1, long num2) {
        return num1 + num2;
    }

    public static long subtract(long num1, long num2) {
        return num1 - num2;
    }

    public static long multiply(long num1, long num2) {
        return num1 * num2;
    }

    public static long divide(long num1, long num2) {
        return num1 / num2;
    }

    public long evaluate() {
        return this.expression.decomposition();
    }
}
