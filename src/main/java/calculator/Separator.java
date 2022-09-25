package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = "[,|:]";
    private static final int GROUP_DELIMITER = 1;
    private static final int GROUP_NUMBER = 2;

    public static String[] separate(String expression) {
        String[] numbers = expression.split(DELIMITER);

        Matcher matcher = CUSTOM_DELIMITER.matcher(expression);
        if (matcher.find()) {
            numbers = matcher.group(GROUP_NUMBER).split(matcher.group(GROUP_DELIMITER));
        }

        return numbers;
    }
}
