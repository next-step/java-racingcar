package calculator;

import calculator.expression.Expression;
import calculator.interpreter.Interpreter;

public class StringCalculator {

    private StringCalculator() {}

    public static int calculate(String expressionString) {
        Expression expression = Interpreter.interpret(expressionString);

        return expression.calculate();
    }
}
