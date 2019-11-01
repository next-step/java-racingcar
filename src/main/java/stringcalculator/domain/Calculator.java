package stringcalculator.domain;

import java.util.Objects;

public class Calculator {

    private final SimpleParser parser;
    private final Expression expression;

    public Calculator(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("문자열이 null이거나 빈 공백 문자열은 허용하지 않습니다.");
        }

        this.parser = new SimpleParser(input);
        this.expression = parser.parse();
    }

    public int calculate() {
        return expression.operate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(parser, that.parser) &&
                Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parser, expression);
    }
}
