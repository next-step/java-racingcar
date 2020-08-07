package stringcalculator;

public class StringCalculator {

    public int calculate(String input) {
        SimpleExpression expression = new SimpleExpression(input);
        int result = expression.getInteger(0);

        for (int i = 1; i < expression.getLength() - 1; i++) {
            OperatorType operator = OperatorType.getOperatorType(expression.get(i));
            result = operator.calculate(result, expression.getInteger(++i));
        }

        return result;
    }

}
