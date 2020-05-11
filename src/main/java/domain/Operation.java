package domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static domain.Operand.ZERO;

public enum Operation {
    PLUS("+", (o1, o2) -> new Operand(o1.getValue() + o2.getValue())),
    SUBTRACT("-", (o1, o2) -> new Operand(o1.getValue() - o2.getValue())),
    MULTIPLICATION("*", (o1, o2) -> new Operand(o1.getValue() * o2.getValue())),
    DIVISION("/", Operation::divide);

    private final String type;
    private final BinaryOperator<Operand> computationStrategy;

    Operation(String type, BinaryOperator<Operand> computationStrategy) {
        this.type = type;
        this.computationStrategy = computationStrategy;
    }

    private static Operand divide(Operand o1, Operand o2) {
        if (o2.equals(ZERO)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return new Operand(o1.getValue() / o2.getValue());
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

}
