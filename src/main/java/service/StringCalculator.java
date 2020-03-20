package service;

import domain.StringExpression;

public class StringCalculator {
    public static Integer calculate(String expressionString) {
        StringExpression expression = StringExpression.newInstance(expressionString);
        return expression.solve();
    }
}
