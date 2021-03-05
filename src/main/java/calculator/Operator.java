package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public enum Operator {

    PLUS("+", (x,y) -> (x + y)),
    MINUS("-", (x, y) -> (x - y)),
    MULTIPLY("*", (x, y) -> (x * y)),
    DIVIDE("/", (x, y) -> (x / y));

    private String operation;
    private BiFunction<Integer,Integer,Integer> value;

    Operator(String operation, BiFunction<Integer,Integer,Integer> value) {
        this.operation = operation;
        this.value = value;
    }

    public int calculate(int x,int y) {
        return value.apply(x,y);
    }

    private String getOperation() {
        return this.operation;
    }

    public static Operator findOperation(String operation) {
       return Arrays.stream(Operator.values())
               .filter(op -> op.getOperation().equals(operation))
               .findAny()
               .get();
    }

    public static boolean isOperation(String operation) {
        return Arrays.stream(Operator.values())
                .anyMatch(op -> op.getOperation().equals(operation));
    }

}


