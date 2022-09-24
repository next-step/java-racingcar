import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperator {

    final static Pattern CUSTOM_REGEX_PATTERN = Pattern.compile("(//)(.*?)(\n)");
    final static String DEFAULT_REGEX = ",|:|//|\n|";

    private static String message;

    public StringOperator(String message) {
        this.message = message;
    }

    public boolean isNotBlank() {
        return message != null && !message.isBlank();
    }

    public String[] split() {
        return message.split(getRegex(message));
    }

    private String getRegex(String numberString) {
        String regex = DEFAULT_REGEX;

        Matcher matcher = CUSTOM_REGEX_PATTERN.matcher(numberString);

        if (matcher.find()) {
            regex += matcher.group(2).trim();
        }

        return regex;
    }

}
