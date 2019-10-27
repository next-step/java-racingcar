package step1.calculator;

import java.util.Queue;

public class ProcessUnit<T> {
    private final Queue<T> operands;
    private final Queue<Operators<T>> operators;

    public ProcessUnit(Queue<T> operands, Queue<Operators<T>> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public T operate() {
        T result = operands.poll();

        for (Operators<T> operator : operators) {
            result = operator.operation(result, operands.poll());
        }

        validateConsumeAllOperand();

        return result;
    }

    private void validateConsumeAllOperand() {
        if (!operands.isEmpty()) {
            throw new RuntimeException("Unhandled operand exist");
        }
    }
}
