package calculator.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern PATTERN = Pattern.compile("[\\d */+-]+");

    private final Operand left;

    private final Operand right;

    private final Operator operator;

    public Expression(Operand left, Operand right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public static String verify(String expression) {
        if (isNullOrEmpty(expression)) {
            throw new IllegalArgumentException("입력값은 null 또는 빈문자열일 수 없습니다.");
        }

        if (!PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException("입력값에 올바르지 않은 문자열이 포함되어 있습니다.");
        }

        return expression;
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

    public Operand calculate() {
        double result = operator.apply(left.getValue(), right.getValue());
        return Operand.of(result);
    }
}
