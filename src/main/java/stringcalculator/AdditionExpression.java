package stringcalculator;

public class AdditionExpression implements Expression {
    private Expression augend;
    private Expression addend;

    public AdditionExpression(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }


    @Override
    public int calculate() {
        return augend.calculate()+ addend.calculate();
    }
}
