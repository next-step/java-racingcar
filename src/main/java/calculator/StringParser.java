package calculator;

import calculator.exception.UnexpectedCharacterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\\R(.*)");

    private StringParser() {

    }

    public static String[] split(String text) {
        Matcher matcher = PATTERN.matcher(text);
        String delimiter = DEFAULT_DELIMITER;

        if (matcher.find()) {
            delimiter = extractCustomDelimiter(matcher);
            text = matcher.group(2);
        }

        validateText(text, delimiter);

        return text.split(delimiter);
    }

    private static String extractCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return String.join("|", DEFAULT_DELIMITER, customDelimiter);
    }

    private static void validateText(String text, String delimiter) {
        String validPattern = String.format("^(-?)[0-9%s]+$", delimiter.replace("|", ""));
        if (!text.matches(validPattern)) {
            throw new UnexpectedCharacterException();
        }
    }
}
