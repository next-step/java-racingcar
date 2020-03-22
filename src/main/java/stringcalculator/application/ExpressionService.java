package stringcalculator.application;

import stringcalculator.domain.Expression;

public class ExpressionService {

    public double calculate(Expression toExpression) {
        return toExpression.calculate();
    }
}
