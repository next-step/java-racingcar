package calculator;

@FunctionalInterface
public interface OperatorFunction {
    long operate(long a, long b);

    static OperatorFunction wrap(OperatorFunction operatorFunction) {
        return (a, b) -> {
            try {
                return operatorFunction.operate(a, b);
            } catch (Exception e) {
                throw new OperatorException(e.getMessage());
            }
        };
    }
}
