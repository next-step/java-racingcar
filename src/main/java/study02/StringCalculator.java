package study02;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StringCalculator {

    private final Stack<Operand> operandStack = new Stack<>();
    private final Stack<Operator> operatorStack = new Stack<>();

    public StringCalculator(String formula) {
        this(new Formula(formula));
    }

    public StringCalculator(Formula formula) {
        this(formula.getOperandList(), formula.getOperatorList());
    }

    private StringCalculator(List<Operand> operandList, List<Operator> operatorList) {
        List<Operand> copyOperandList = operandList.subList(0, operandList.size());
        List<Operator> copyOperatorList = operatorList.subList(0, operatorList.size());
        Collections.reverse(copyOperandList);
        Collections.reverse(copyOperatorList);

        operandStack.addAll(copyOperandList);
        operatorStack.addAll(copyOperatorList);
    }

    public Operand calculate() {
        while (!isDone()) {
            Operator operator = operatorStack.pop();
            operandStack.push(operator.calculate(operandStack.pop(), operandStack.pop()));
        }
        return operandStack.pop();
    }

    private boolean isDone() {
        return operatorStack.empty() && operandStack.size() == 1;
    }

    // Test Code Only
    public Stack<Operand> getOperandStack() {
        return this.operandStack;
    }

    // Test Code Only
    public Stack<Operator> getOperatorStack() {
        return this.operatorStack;
    }
}
