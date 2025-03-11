package step2;

public class Tokens {
    private final String[] value;

    public Tokens(String text, Separator separator) {
        value = split(text, separator);
    }

    private String[] split(String text, Separator separator) {
        if (text.startsWith("//") && text.charAt(3) == '\n') {
            text = text.substring(4);
        }
        return text.split("[" + separator.value() + "]");
    }

    public String[] value() {
        return value;
    }
}
