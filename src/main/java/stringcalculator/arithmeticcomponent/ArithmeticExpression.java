package stringcalculator.arithmeticcomponent;

/**
 * 1회 연산에 필요한 수식
 * 구성 ( 연산자, 피연산자1, 피연산자2 )
 */
public class ArithmeticExpression {
    private ArithmeticOperator operator;
    private ArithmeticOperand operand1;
    private ArithmeticOperand operand2;

    public ArithmeticExpression(ArithmeticOperator operator, ArithmeticOperand operand1, ArithmeticOperand operand2) {
        if (!isValid(operator, operand1, operand2)) {
            throw new IllegalArgumentException();
        }
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    private boolean isValid(ArithmeticOperator operator, ArithmeticOperand operand1, ArithmeticOperand operand2) {
        return operator != null && operand1 != null && operand2 != null;
    }

    public ArithmeticOperator getOperator() {
        return operator;
    }

    public ArithmeticOperand getOperand1() {
        return operand1;
    }

    public ArithmeticOperand getOperand2() {
        return operand2;
    }
}
