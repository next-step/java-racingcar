package stringcalculator;

public class ParseInfo {
    public final String delimiter;
    public final String text;

    public ParseInfo(String delimiter, String text) {
        this.delimiter = delimiter;
        this.text = text;
    }

    public String[] parse() {
        return text.split(delimiter);
    }
}
