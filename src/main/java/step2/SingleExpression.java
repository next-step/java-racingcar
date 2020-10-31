package step2;

public class SingleExpression {

    private final Operand operand1;
    private final Operator operator;
    private final Operand operand2;

    public SingleExpression(ExpressionFactor operand1, ExpressionFactor operator, ExpressionFactor operand2) {
        this.operand1 = (Operand) operand1;
        this.operator = (Operator) operator;
        this.operand2 = (Operand) operand2;
    }

    public Operand getOperand1() {
        return operand1;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operand getOperand2() {
        return operand2;
    }

    public int operate() {
        return operator.operate(operand1.getValue(), operand2.getValue());
    }
}
