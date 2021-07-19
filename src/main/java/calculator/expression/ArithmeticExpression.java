package calculator.expression;

import calculator.interpreter.Interpreter;
import calculator.interpreter.MatchedExpression;
import calculator.operator.Operator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArithmeticExpression that = (ArithmeticExpression) o;
        return Objects.equals(subExpression, that.subExpression) && operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subExpression, operator);
    }
}
