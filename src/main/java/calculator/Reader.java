package calculator;

public class Reader {

    private final String separator;

    public Reader(final String separator) {
        this.separator = separator;
    }

    Expression read(String value) {
        return Expression.of(value.split(separator));
    }
}
