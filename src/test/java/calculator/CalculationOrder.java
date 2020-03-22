package calculator;

import java.util.Stack;

public class CalculationOrder {

    private static final int BINOMIAL_EXPRESSION_SIZE = 3;
    private static final int ADDITIONAL_INPUT_SIZE = 2;
    private static final int ODD_NUMBER = 1;
    private static final int EVEN_NUMBER = 2;
    private static final int INDEX_INTERVAL = 2;

    private Stack<Long> numberStack = new Stack<>();
    private Stack<Operator> operatorStack = new Stack<>();

    public void init(String[] inputs) {
        addStackReverse(inputs);
    }

    private void addStackReverse(String[] inputs) {
        verifyInputs(inputs);
        addOperationStack(inputs);
        addNumberStack(inputs);

    }

    private void verifyInputs(String[] inputs) {
        if ((inputs.length - BINOMIAL_EXPRESSION_SIZE) % ADDITIONAL_INPUT_SIZE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void addOperationStack(String[] inputs) {
        for (int i = inputs.length - EVEN_NUMBER; i >= 0; i = i - INDEX_INTERVAL) {
            operatorStack.push(Operator.findOperatorByValue(inputs[i]));
        }
    }

    private void addNumberStack(String[] inputs) {
        for (int i = inputs.length - ODD_NUMBER; i >= 0; i = i - INDEX_INTERVAL) {
            numberStack.push(parseLong(inputs[i]));
        }
    }

    private long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public BinomialExpression nextBinomialExpression() {
        if (isCalculate()) {
            return new BinomialExpression(numberStack.pop(), numberStack.pop(), operatorStack.pop());
        }
        throw new IllegalArgumentException();
    }

    public boolean isCalculate() {
        return operatorStack.size() > 0 && numberStack.size() > 1;
    }

    public void addCalculateResult(long result) {
        numberStack.push(result);
    }

    public long getCurrentNumber() {
        return numberStack.pop();
    }
}
