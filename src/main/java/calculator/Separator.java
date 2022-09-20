package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = "[,|:]";

    public static String[] separate(String expression) {
        String[] numbers = expression.split(DELIMITER);

        Matcher matcher = CUSTOM_DELIMITER.matcher(expression);
        if (matcher.find()) {
            String delimiter = matcher.group(1);

            numbers = matcher.group(2).split(delimiter);
        }

        return numbers;
    }
}
