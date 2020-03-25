package calculator;

public class BinomialExpression {
    private long firstNumber;
    private long secondNumber;
    private Operator operator;

    public BinomialExpression(long firstNumber, long secondNumber, Operator operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public long calculate() {
        return operator.calculate(firstNumber, secondNumber);
    }
}
