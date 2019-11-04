package stringcalculator.domain;

import java.util.Objects;

public class SimpleParser implements Parser {

    private static final String DELIMITER = " ";
    private final String unParsedExpression;

    public SimpleParser(String unParsedExpression) {
        this.unParsedExpression = unParsedExpression;
    }

    public Expression parse() {
        Expression expression = new Expression();
        String[] units = unParsedExpression.split(DELIMITER);
        for (String unit : units) {
            expression.add(unit);
        }
        return expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleParser parser = (SimpleParser) o;
        return Objects.equals(unParsedExpression, parser.unParsedExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unParsedExpression);
    }
}
