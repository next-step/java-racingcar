package step2.calculator;

public class ExpressionWith {
    int frontNumber;
    int backNumber;
    Expression expression;

    protected ExpressionWith(int frontNumber, Expression expression, int backNumber) {
        this.frontNumber = frontNumber;
        this.expression = expression;
        this.backNumber = backNumber;
    }

    public int calculate() {
        return expression.calculate(this);
    }

    static public ExpressionWith of(int a, Expression expression, int b) {
        return new ExpressionWith(a, expression, b);
    }
}
