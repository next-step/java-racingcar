package calculator;

public class StringOperator {
    private final Delimiter delimiter;
    private final String numericText;

    public StringOperator(String text) {
        this.delimiter = Delimiter.of(text);
        this.numericText = this.delimiter.isCustomDelimiter() ? text.split("\n")[1] : text;
    }

    public String[] split() {
        return this.numericText.split(this.delimiter.delimiterExpression());
    }
}
