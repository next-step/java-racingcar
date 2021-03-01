package stringcalculator;

public class SubtractionExpression implements Expression{
    private Expression minuend;
    private Expression subtrahend;

    public SubtractionExpression(Expression minuend, Expression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public int calculate() {
        return minuend.calculate()-subtrahend.calculate();
    }
}
