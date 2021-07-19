package calculator.expression;

import calculator.interpreter.Interpreter;
import calculator.interpreter.SplitExpression;
import calculator.operator.Operator;

import java.util.Objects;

public class ArithmeticExpression extends Expression {

    private final Expression subExpression;
    private final Operator operator;

    private ArithmeticExpression(SplitExpression splitExpression) {
        this.subExpression = Interpreter.interpret(splitExpression.getSubExpressionString());
        this.operator = Operator.of(splitExpression.getOperatorString());
        this.operand = Integer.parseInt(splitExpression.getOperandString());
    }

    public static ArithmeticExpression of(SplitExpression splitExpression) {
        return new ArithmeticExpression(splitExpression);
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
