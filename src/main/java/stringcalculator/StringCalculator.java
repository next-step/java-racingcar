package stringcalculator;

public class StringCalculator {

    public int calculate(String input) {
        ExpressionFactory expressionFactory = new ExpressionFactory();
        Expression expression = expressionFactory.create(input);
        return expression.calculate();
    }


}
