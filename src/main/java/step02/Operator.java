package step02;

import exception.InValidOperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Math::addExact),
    MINUS("-", Math::subtractExact),
    MULTIPLE("*", Math::multiplyExact),
    DIVIDE("/", (x, y) -> x / y);

    private final String operatorType;
    private final BiFunction<Integer, Integer, Integer> operator;

    Operator(String operatorType, BiFunction<Integer, Integer, Integer> operator) {
        this.operatorType = operatorType;
        this.operator = operator;
    }

    public int calculate(int x, int y) {
        return operator.apply(x, y);
    }

    public static int executeOf(String type, int x, int y) {
        return Arrays.stream(values())
                     .filter(operator -> operator.operatorType.equals(type))
                     .findFirst()
                     .orElseThrow(InValidOperatorException::new)
                     .calculate(x, y);
    }

}
