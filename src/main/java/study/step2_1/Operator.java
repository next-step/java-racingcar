package study.step2_1;

import java.util.Optional;
import java.util.function.BinaryOperator;
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

    public static Optional<Operator> findOperator(String operator){
        return Stream.of(Operator.values())
                .filter(value -> value.operatorType.equals(operator))
                .findAny();
    }

    public static ToDoubleBiFunction<Double,Double> getOperationType(String operator) {
        return findOperator(operator).orElseThrow(()->new IllegalArgumentException()).operation;
    }

    public static boolean isOperator(String value){
        if (!Validator.isBlank(value)){
            return Operator.findOperator(value).isPresent();
        }
        return false;
    }

    public static double calculate(String operator, Double currentNumber, Double nextNumber){
        return getOperationType(operator).applyAsDouble(currentNumber, nextNumber);
    }
}