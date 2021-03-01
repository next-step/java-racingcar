package stringcalculator;

public class MultiplicationExpression implements Expression{

    private Expression multiplicand;

    private Expression multiplier;

    public MultiplicationExpression(Expression multiplicand, Expression multiplier) {
        this.multiplicand = multiplicand;
        this.multiplier = multiplier;
    }

    @Override
    public int calculate() {
        return multiplicand.calculate()*multiplier.calculate();
    }
}
