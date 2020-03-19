package stringcalculator;

import java.util.Objects;
import java.util.regex.Pattern;

public class Operator {
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("^(\\+)|(-)|(\\*)|(/)$");
    private final String operator;

    public Operator(String operator) {
        if (!OPERATOR_PATTERN.matcher(operator).find()) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operator)) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(getOperator(), operator1.getOperator());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperator());
    }
}
