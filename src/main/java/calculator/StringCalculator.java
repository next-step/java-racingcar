package calculator;

public class StringCalculator {

    private final Reader reader;

    public StringCalculator(final Reader reader) {
        this.reader = reader;
    }

    public int calculate(final String value) {
        return reader.read(value)
                .calculate()
                .getValue();
    }
}
