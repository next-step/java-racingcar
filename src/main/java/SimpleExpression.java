
public class SimpleExpression {
    private final Pair<Integer> operandPair;
    private final Operator operator;

    public SimpleExpression(Pair<Integer> operandPair, Operator operator) {
        this.operandPair = operandPair;
        this.operator = operator;
    }

    public Pair<Integer> getOperandPair() {
        return operandPair;
    }

    public Operator getOperator() {
        return operator;
    }
}
