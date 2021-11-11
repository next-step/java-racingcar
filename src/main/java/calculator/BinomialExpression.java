package calculator;

public class BinomialExpression {

    private final long operand1;
    private final long operand2;
    private final Operator operator;

    public BinomialExpression(long operand1, long operand2, String operatorSymbol) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = Operator.of(operatorSymbol);
    }

    public long calculate() {
        return operator.calculate(operand1, operand2);
    }
}
