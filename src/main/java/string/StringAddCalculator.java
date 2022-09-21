package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int result = 0;

        if (isEmpty(text)) {
            return result;
        }

        result = sum(splitText(text));

        return result;
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private static int sum(String[] splitText) {
        return Arrays.stream(splitText)
            .mapToInt(StringAddCalculator::convertNumber)
            .sum();
    }

    private static int convertNumber(String text) {
        int result = 0;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IncludeNotNumberException(text);
        }
        return result;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

}
