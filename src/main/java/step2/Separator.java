package step2;

public class Separator {
    private static final String DEFAULT_SEPARATORS = ",:";
    private final String value;

    public Separator(String text) {
        value = extractSeparator(text);
    }

    private String extractSeparator(String text) {
        if (text.startsWith("//") && text.charAt(3) == '\n') {
            return DEFAULT_SEPARATORS + text.charAt(2);
        }
        return DEFAULT_SEPARATORS;
    }

    public String value() {
        return value;
    }
}
