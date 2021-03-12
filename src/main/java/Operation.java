import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operation {
    PLUS("+", (int1, int2) -> int1 + int2),
    MINUS("-", (int1, int2) -> int1 - int2),
    MULTIPLY("*", (int1, int2) -> int1 * int2),
    DIVIDE("/", (int1, int2) -> int1 / int2);

    private String operator;
    private BinaryOperator<Integer> integerBinaryOperator;

    Operation(String operator, BinaryOperator<Integer> integerBinaryOperator) {
        this.operator = operator;
        this.integerBinaryOperator = integerBinaryOperator;
    }

    public static Operation of(String value) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.operator.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Message.EMPTY_OPERATOR));
    }

    public Integer getResult(Integer num1, Integer num2) {
        return this.integerBinaryOperator.apply(num1,num2);
    }


}
