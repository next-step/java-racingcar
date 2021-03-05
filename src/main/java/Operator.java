import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (int1, int2) -> int1 + int2),
    MINUS("-", (int1, int2) -> int1 - int2),
    MULTIPLY("*", (int1, int2) -> int1 * int2),
    DIVIDE("/", (int1, int2) -> int1 / int2);

    private String operator;
    private BinaryOperator<Integer> integerBinaryOperator;

    Operator(String operator, BinaryOperator<Integer> integerBinaryOperator) {
        this.operator = operator;
        this.integerBinaryOperator = integerBinaryOperator;
    }

    public static Operator of(String operator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getResult(Integer num1, Integer num2) {
        return this.integerBinaryOperator.apply(num1,num2);
    }


}
