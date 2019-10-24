package calculator;

@FunctionalInterface
public interface OperatorFunction {
    long operate(long a, long b);
}
