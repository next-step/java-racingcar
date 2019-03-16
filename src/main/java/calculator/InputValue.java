package calculator;

public class InputValue {
    private Delimiter delimiter;

    public InputValue(String input) {
        this.delimiter = new Delimiter(extractDelimiterWord(input));
    }

    private String extractDelimiterWord(String input) {
        if (input.startsWith("//")) {
            return input.substring(2, input.indexOf("\n"));
        }

        return ",|:";
    }

    public String getDelimiterWord() {
        return delimiter.getDelimiter();
    }
}
