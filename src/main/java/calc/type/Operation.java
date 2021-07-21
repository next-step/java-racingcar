package calc.type;

import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (a, b) -> (int) a + (int) b),
    MINUS("-", (a, b) -> (int) a - (int) b),
    MULTIPLY("*", (a, b) -> (int) a * (int) b),
    DIVIDE("/", (a, b) -> (int) a / (int) b);

    private String operation;
    private BiFunction<Integer, Integer, Integer> resultFunction;

    Operation(String operation, BiFunction resultFunction) {
        this.operation = operation;
        this.resultFunction = resultFunction;
    }

    public Integer calc(int a, int b) {
        return this.findByOperation(this.operation).resultFunction.apply(a, b);
    }

    public static Operation findByOperation(String operation) {
        for(Operation o : Operation.values()) {
            if(operation.equals(o.operation)) {
                return o;
            }
        }
        throw new IllegalArgumentException("not support operation");
    }

}
