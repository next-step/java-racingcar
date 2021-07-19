package calculator.helper;

import calculator.expression.ArithmeticExpression;
import calculator.interpreter.MatchedExpression;

public class Generator {
    public static ArithmeticExpression arithmeticExpressionOf(String subExpression, String operator, String operand) {
        return ArithmeticExpression.of(matchedExpressionOf(subExpression, operator, operand));
    }

    public static MatchedExpression matchedExpressionOf(String subExpression, String operator, String operand) {
        return new MatchedExpression(subExpression + " " + operator + " " + operand);
    }
}
