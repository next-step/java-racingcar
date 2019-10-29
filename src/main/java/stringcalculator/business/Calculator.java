package stringcalculator.business;

import java.util.Stack;

public class Calculator {

    private static final String DELIMITER = " ";

    private CentralProcessingUnit cpu;
    private Memory memory;

    public Calculator() {
        this(new CentralProcessingUnit(), new Memory());
    }

    Calculator(final CentralProcessingUnit cpu, final Memory memory) {
        this.cpu = cpu;
        this.memory = memory;
    }

    public void input(final String expression) {
        validate(expression);
        parseAndStore(expression);
    }

    private void validate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void parseAndStore(final String expression) {
        final String[] seperatedExpression = expression.split(DELIMITER);
        int expressionSize = seperatedExpression.length;

        if (expressionSize % 2 == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = expressionSize - 1; i >= 0; i--) {
            final String unit = seperatedExpression[i];
            final boolean isOperand = i % 2 == 0;
            memory.store(isOperand ? Operand.of(unit) : Operator.of(unit));
        }
    }

    public int calculate() {

        final Stack<Operand> operands = memory.getOperands();
        final Stack<Operator> operators = memory.getOperators();
        final int operationCount = operators.size();

        int result = operands.pop().getValue();

        for (int i = 0; i < operationCount; i++) {
            Operand operand = operands.pop();
            Operator operator = operators.pop();
            result = cpu.operate(result, operand.getValue(), operator.getValue());
        }

        return result;
    }
}