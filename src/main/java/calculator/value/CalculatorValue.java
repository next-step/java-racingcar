package calculator.value;

public class CalculatorValue {
    private String operator;
    private Long operand1;
    private Long operand2;

    public static CalculatorValue of(String operator, Long operand1, Long operand2) {
        CalculatorValue value = new CalculatorValue();
        value.operator = operator;
        value.operand1 = operand1;
        value.operand2 = operand2;
        return value;
    }

    public String getOperator() {
        return operator;
    }

    public Long getOperand1() {
        return operand1;
    }

    public Long getOperand2() {
        return operand2;
    }
}
