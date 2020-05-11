package domain.operation;

import domain.Operand;

import java.util.Arrays;

public enum Operation {
    PLUS("+", BasicComputationStrategy::plus),
    SUBTRACT("-", BasicComputationStrategy::subtract),
    MULTIPLICATION("*", BasicComputationStrategy::multiply),
    DIVISION("/", BasicComputationStrategy::divide);

    private final String type;
    private final ComputationStrategy computationStrategy;

    Operation(String type, ComputationStrategy computationStrategy) {
        this.type = type;
        this.computationStrategy = computationStrategy;
    }

    public static Operation findByType(String type) {
        return Arrays.stream(values())
                .filter(value -> value.type.equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 올바른 연산자가 아닙니다.", type)));
    }

    public Operand operate(Operand input, Operand operand) {
        return computationStrategy.compute(input, operand);
    }
}
