package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        int result = 0;

        for (String token : splitByDelimiter(input)) {
            result += Integer.parseInt(token);
        }

        return result;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitByDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }
}
