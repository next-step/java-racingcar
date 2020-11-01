import java.util.Arrays;
import java.util.function.BiFunction;

enum Operator {
    PLUS("+", (leftNumber, rightNumber) -> leftNumber + rightNumber),
    MINUS("-", (leftNumber, rightNumber) -> leftNumber - rightNumber),
    MULTIPLY("*", (leftNumber, rightNumber) -> leftNumber * rightNumber),
    DIVIDE("/", (leftNumber, rightNumber) -> leftNumber / rightNumber);

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator (String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public Double calculator (Double leftNumber, Double rightNumber) {
        return expression.apply(leftNumber, rightNumber);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 아닙니다."));
    }
}
