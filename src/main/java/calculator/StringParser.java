package calculator;

import calculator.exception.UnexpectedCharacterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";

    private StringParser() {

    }

    public static String[] split(String text) {
        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher m = pattern.matcher(text);
        String delimiter = DEFAULT_DELIMITER;

        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter = String.join("|", delimiter, customDelimiter);
            text = m.group(2);
        }

        validateText(text, delimiter);

        return text.split(delimiter);
    }

    private static void validateText(String text, String delimiter) {
        String validPattern = String.format("^[0-9%s]+$", delimiter.replace("|", ""));
        if (!text.matches(validPattern)) {
            throw new UnexpectedCharacterException();
        }
    }
}
