package domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static domain.Operand.ZERO;

public enum Operation {
    PLUS("+", (input, operand) -> new Operand(input.getValue() + operand.getValue())),
    SUBTRACT("-", (input, operand) -> new Operand(input.getValue() - operand.getValue())),
    MULTIPLICATION("*", (input, operand) -> new Operand(input.getValue() * operand.getValue())),
    DIVISION("/", Operation::divide);

    private final String type;
    private final BinaryOperator<Operand> computationStrategy;

    Operation(String type, BinaryOperator<Operand> computationStrategy) {
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
        return computationStrategy.apply(input, operand);
    }

    private static Operand divide(Operand input, Operand operand) {
        if (operand.equals(ZERO)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return new Operand(input.getValue() / operand.getValue());
    }

}
