package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private String text;
    private String delimiter;

    public Splitter(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    public String[] split() {
        return text.split(delimiter);
    }
}
