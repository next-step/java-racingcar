package calculator.expression;

import calculator.interpreter.Interpreter;
import calculator.interpreter.MatchedExpression;
import calculator.operator.Operator;

public class ArithmeticExpression extends Expression {

    private final Expression subExpression;
    private final Operator operator;

    private ArithmeticExpression(MatchedExpression matchedExpression) {
        this.subExpression = Interpreter.interpret(matchedExpression.getSubExpressionString());
        this.operator = Operator.of(matchedExpression.getOperatorString());
        this.operand = Integer.parseInt(matchedExpression.getOperandString());
    }

    public static ArithmeticExpression of(MatchedExpression matchedExpression) {
        return new ArithmeticExpression(matchedExpression);
    }

    @Override
    public int calculate() {
        return operator.operate(subExpression.calculate(), operand);
    }
}
