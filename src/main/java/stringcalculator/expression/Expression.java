package stringcalculator.expression;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Expression {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d+$");
    private static final int FIRST_INDEX = 0;
    private static final String DELIMITER = " ";

    private String[] expressions;
    private Numbers numbers;
    private Operators operatos;

    public Expression(String source) {
        if (source == null || "".equals(source.trim())) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        this.expressions = source.split(DELIMITER);
        if (!INTEGER_PATTERN.matcher(getExpression()[FIRST_INDEX]).find()) {
            throw new IllegalArgumentException("입력 값은 숫자부터 시작해야 합니다.");
        }
        this.numbers = new Numbers(this);
        this.operatos = new Operators(this);
    }

    String[] getExpression() {
        return expressions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return Arrays.equals(expressions, that.expressions);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(expressions);
    }
}
