package calculator.expression;

import calculator.interpreter.Interpreter;
import calculator.interpreter.MatchedExpression;
import calculator.operator.Operator;

public class ArithmethicExpression extends Expression {

    private Expression subExpression;
    private Operator operator;

    private ArithmethicExpression(MatchedExpression matchedExpression) {
        this.subExpression = Interpreter.interpret(matchedExpression.getSubExpressionString());
    }

    @Override
    public int calculate() {
        return operator.operate(subExpression.calculate(), operand);
    }
}
