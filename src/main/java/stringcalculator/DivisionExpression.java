package stringcalculator;

public class DivisionExpression implements Expression {

    private Expression dividend;

    private Expression divisor;


    public DivisionExpression(Expression dividend, Expression divisor) {
        this.divisor = divisor;
        this.dividend = dividend;
    }

    @Override
    public int calculate() {
        return dividend.calculate()/divisor.calculate();
    }
}
