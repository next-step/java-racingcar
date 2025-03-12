package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokens {
    private final String[] value;
    private static final Pattern SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public Tokens(String text, Separator separator) {
        value = split(text, separator);
    }

    private String[] split(String text, Separator separator) {
        String separatorRegex = "[" + separator.value() + "]";

        Matcher matcher = SEPARATOR_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(separatorRegex);
        }
        return text.split(separatorRegex);
    }

    public String[] value() {
        return value;
    }
}
