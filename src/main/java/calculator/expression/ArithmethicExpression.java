package calculator.expression;

import calculator.operator.Operator;

public class ArithmethicExpression extends Expression {

    private Expression subExpression;
    private Operator operator;

    private ArithmethicExpression(String expressionString) {
    }

    @Override
    public int calculate() {
        return operator.operate(subExpression.calculate(), operand);
    }
}
