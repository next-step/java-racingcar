package calculator;

public class BinomialExpression {

    private final Long operand1;
    private final Long operand2;
    private final Operator operator;

    public BinomialExpression(Long operand1, Long operand2, String operatorSymbol) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = Operator.of(operatorSymbol);
    }

    public Long calculate() {
        return operator.calculate(operand1, operand2);
    }
}
