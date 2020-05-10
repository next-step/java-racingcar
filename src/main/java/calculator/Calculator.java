package calculator;

import java.util.Objects;

public class Calculator {
    private String expression;

    public Calculator(String expression) {
        this.validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public double calculate() {
        String[] splitExpression = this.expression.split(" ");
        double result = Double.parseDouble(splitExpression[0]);
        for (int i = 1; i < splitExpression.length; i += 2) {
            Operator operator = Operator.findOperator(splitExpression[i]);
            result = operator.calculate(result, Double.parseDouble(splitExpression[i + 1]));
        }
        return result;
    }
}
