package calculator.domain;

@FunctionalInterface
public interface OperationInterface {

    int operate(int left, int right);
}
