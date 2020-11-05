package stringcalculator;

public class Calculator {

    public int calculate(String input) {
        Expression expression = new Expression(input);
        int result = expression.getInteger(0);
        for (int i = 1, length = expression.getLength() -1 ; i < length ; i++) {
            Operator operator = Operator.getOperator(expression.get(i));
            result = operator.calculate(result, expression.getInteger(++i));
        }
        return result;
    }
}
