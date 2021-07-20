package calculator.helper;

import calculator.expression.ArithmeticExpression;
import calculator.interpreter.SplitExpression;

public class Generator {
    private Generator() {}

    public static ArithmeticExpression arithmeticExpressionOf(String subExpression, String operator, String operand) {
        return ArithmeticExpression.of(splitExpressionOf(subExpression, operator, operand));
    }

    public static SplitExpression splitExpressionOf(String subExpression, String operator, String operand) {
        return new SplitExpression(subExpression + " " + operator + " " + operand);
    }
}
