import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private String separator;
    private String inputString;
    private static String DEFAULT_SEPARATOR = ",:";
    public StringSplitter(String separator, String inputString) {
        this.separator = separator;
        this.inputString = inputString;
    }

    public static StringSplitter from(String input) {
        Pattern pattern = Pattern.compile("//(.+)\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return new StringSplitter(matcher.group(1) + DEFAULT_SEPARATOR, matcher.group(2));
        }
        return new StringSplitter(DEFAULT_SEPARATOR, input);
    }

    public String getSeparator() {
        return separator;
    }

    public String getInputString() {
        return inputString;
    }
}
