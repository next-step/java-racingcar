package calculator.interpreter;

import calculator.expression.ArithmeticExpression;
import calculator.expression.Expression;
import calculator.expression.Number;

public class Interpreter {

    private Interpreter() {}

    public static Expression interpret(String expressionString) {
        SplitExpression splitExpression = new SplitExpression(expressionString);

        if (splitExpression.isArithmeticExpression()) {
            return ArithmeticExpression.of(splitExpression);
        }

        return Number.of(expressionString);
    }
}
