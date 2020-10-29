package step2.domain;


import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {


    PLUS("+" , (x,y) -> x+y),
    MINUS("-" , (x,y) -> x-y),
    MULTIPLY("*" , (x,y) -> x*y),
    DIVISION("/" , (x,y) -> x/y);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }
    public static int operate(OperatedNumber operatedNumber , String operator){
        return Arrays.stream(Operator.values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new)
                .operation
                .apply(operatedNumber.getOperateResult() , operatedNumber.getNextNumber());
    }

}
