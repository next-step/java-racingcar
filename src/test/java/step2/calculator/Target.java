package step2.calculator;

public class Target {
    int a;
    int b;
    Expression expression;

    protected Target(int a, Expression expression, int b) {
        this.a = a;
        this.expression = expression;
        this.b = b;
    }

    public int calculate() {
        return expression.calculate(a, b);
    }

    static public Target create(int a, Expression expression, int b) {
        return new Target(a, expression, b);
    }
}
