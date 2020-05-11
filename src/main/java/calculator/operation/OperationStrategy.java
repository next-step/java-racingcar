package calculator.operation;

@FunctionalInterface
public interface OperationStrategy {
    int operate(int operandA, int operandB);
}
