package calculator.interpreter;

import calculator.expression.ArithmeticExpression;
import calculator.expression.Expression;
import calculator.expression.Number;

public class Interpreter {

    private Interpreter() {}

    public static Expression interpret(String expressionString) {
        MatchedExpression matchedExpression = new MatchedExpression(expressionString);

        if (matchedExpression.isValidExpression()) {
            return ArithmeticExpression.of(matchedExpression);
        }

        return Number.of(expressionString);
    }
}
