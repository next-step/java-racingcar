package caculator.model;

public class ParsedText {

    private final Delimiters delimiters;
    private final String expression;

    public ParsedText(final String delimiters, final String expression) {
        this.delimiters = new Delimiters(delimiters);
        this.expression = expression;
    }

    public Delimiters getDelimiters() {
        return delimiters;
    }

    public String getExpression() {
        return expression;
    }

}
