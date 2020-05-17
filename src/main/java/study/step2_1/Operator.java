package study.step2_1;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", (currentNumber, nextNumber) -> currentNumber + nextNumber),
    SUBTRACT("-", (currentNumber, nextNumber) -> currentNumber - nextNumber),
    MULTIPLY("*", (currentNumber, nextNumber) -> currentNumber * nextNumber),
    DIVISION("/", (currentNumber, nextNumber) -> {
        if (nextNumber == 0) throw new IllegalArgumentException("0값으로 나눌 수 없습니다.");
            return currentNumber / nextNumber;
    });

    private String operatorType;
    private BinaryOperator<Double> operation;

    Operator(String operatorType, BinaryOperator<Double> operation){
            this.operatorType = operatorType;
            this.operation = operation;
    }

    public static Optional<Operator> findOperator(String operator){
        return Stream.of(Operator.values())
                        .filter(value -> value.operatorType.equals(operator))
                        .findAny();
    }

    private static Operator getOperation(String operator){
        return findOperator(operator).orElseThrow(()->new IllegalArgumentException());
    }

    public static BinaryOperator<Double> getOperationType(String operator) {
        return getOperation(operator).operation;
    }

    public static double calculate(String operator, double currentNumber, double nextNumber){
        return getOperationType(operator).apply(currentNumber, nextNumber);
    }

}
