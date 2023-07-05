package caculator.model;

public class Delimiters {

    private static final String[] BASE_DELIMITERS = { ",", ":" };
    private final String customDelimiter;

    public Delimiters() {
        this.customDelimiter = null;
    }

    public Delimiters(final String customDelimiter) {
        this.customDelimiter = customDelimiter;
    }

    public String toRegex() {
        String regex = String.join("|", BASE_DELIMITERS);

        if (this.customDelimiter != null) {
            regex += "|" + this.customDelimiter;
        }

        return regex;
    }

}
