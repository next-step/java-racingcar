package study.step2_1;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", (currentNumber, nextNumber) -> currentNumber + nextNumber),
    SUBTRACT("-", (currentNumber, nextNumber) -> currentNumber - nextNumber),
    MULTIPLY("*", (currentNumber, nextNumber) -> currentNumber * nextNumber),
    DIVISION("/", (currentNumber, nextNumber) -> {
        if (nextNumber == 0) {
            throw new IllegalArgumentException("0값으로 나눌 수 없습니다.");
        }
        return currentNumber / nextNumber;
    });

    private String operatorType;
    private ToDoubleBiFunction operation;

    Operator(String operatorType, ToDoubleBiFunction<Double,Double> operation){
        this.operatorType = operatorType;
        this.operation = operation;
    }

    public static Operator findOperator(String operator){
        return Stream.of(Operator.values())
                .filter(value -> value.operatorType.equals(operator))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException());
    }

    public static boolean isOperator(String value){
        if (!Objects.isNull(value)){
            return Arrays.stream(Operator.values()).anyMatch(v -> v.operatorType.equals(value));
        }
        return false;
    }

    public double calculate(Double currentNumber, Double nextNumber){
        return operation.applyAsDouble(currentNumber, nextNumber);
    }

}
