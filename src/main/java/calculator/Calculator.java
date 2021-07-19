package calculator;

public class Calculator {

    private Expression expression;

    public Calculator() {

    }

    public void setExpression(String expressionString) {
        this.expression = new Expression(expressionString);
    }

    public int calculate() {
        return expression.calculate();
    }
}
