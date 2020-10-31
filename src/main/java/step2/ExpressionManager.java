package step2;

import java.util.Stack;

public class ExpressionManager {

    private final Stack<ExpressionFactor> expressionStack = new Stack<>();

    public ExpressionManager(String[] expression) {
        for (int i = expression.length - 1; i >= 0; i--) {
            addFactorToExpressionStack(expression, i);
        }
    }

    private void addFactorToExpressionStack(String[] expression, int i) {
        ExpressionFactor expressionFactor = null;
        if (i % 2 == 0) {
            expressionFactor = new Operand(expression[i]);
        }
        if (i % 2 == 1) {
            expressionFactor = new Operator(expression[i]);
        }
        expressionStack.push(expressionFactor);
    }

    public boolean hasNext() {
        return expressionStack.size() >= 3;
    }

    public SingleExpression getNextSingleExpression() {
        return new SingleExpression(expressionStack.pop(), expressionStack.pop(), expressionStack.pop());
    }

    public void addCalcResult(int result) {
        expressionStack.push(new Operand(result));
    }

    public int getResult() {
        Operand pop = (Operand) expressionStack.pop();
        return pop.getValue();
    }
}
