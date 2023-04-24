import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSeparator {

    private static final String BASIC_DELIMITER = ",|:";


    public static String[] splitStringByDelimiters(String input) {
        String[] tokens = input.split(BASIC_DELIMITER);

        Matcher customDelimiter = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (customDelimiter.find()) {
            tokens = splitStringByCustomDelimiter(customDelimiter);
        }
        return tokens;
    }

    private static String[] splitStringByCustomDelimiter(Matcher matcher) {
        String[] tokens;
        String customDelimiter = matcher.group(1);
        String delimiters = BASIC_DELIMITER + "|" + customDelimiter;
        tokens = matcher.group(2).split(delimiters);
        return tokens;
    }
}
