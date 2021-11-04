package study02;

import java.util.List;
import java.util.Stack;

public class StringCalculator {

    private Stack<Operand> operandStack = new Stack<>();
    private Stack<Operator> operatorStack = new Stack<>();

    public StringCalculator(String formula) {
        this(new Formula(formula));
    }

    public StringCalculator(Formula formula) {
        this(Operand.parse(formula.getSplitFormula()), Operator.parse(formula.getSplitFormula()));
    }

    private StringCalculator(List<Operand> operandList, List<Operator> operatorList) {
        if (operandList.isEmpty()) {
            throw new IllegalArgumentException("피연산자가 1개 이상이 필요합니다.");
        }
        if (operatorList.isEmpty()) {
            throw new IllegalArgumentException("연산자가 1개 이상이 필요합니다.");
        }
        if (operandList.size() - operatorList.size() != 1) {
            throw new IllegalArgumentException("연산자와 피연산자의 개수가 올바르지 않습니다.");
        }
        operandStack.addAll(operandList);
        operatorStack.addAll(operatorList);
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
