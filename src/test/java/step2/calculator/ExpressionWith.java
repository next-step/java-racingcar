package step2.calculator;

public class ExpressionWith {
    int a;
    int b;
    Expression expression;

    protected ExpressionWith(int a, Expression expression, int b) {
        this.a = a;
        this.expression = expression;
        this.b = b;
    }

    public int calculate() {
        return expression.calculate(a, b);
    }

    static public ExpressionWith create(int a, Expression expression, int b) {
        return new ExpressionWith(a, expression, b);
    }
}
