package study;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        String[] tokens = splitText(text);
        List<String> textTokens = new ArrayList<>(List.of(tokens));

        return textTokens
                .stream()
                .mapToInt(StringAddCalculator::toPositive)
                .sum();
    }

    public static String[] splitText(String text) {
        String customSeparator = findSeparator(text);
        if (StringUtils.isNotBlank(customSeparator)) {
            text = text.substring(text.indexOf("\n") + 1);
            return text.split(SEPARATOR + "|" + customSeparator);
        }

        return text.split(SEPARATOR);
    }

    public static String findSeparator(String text) {
        if (text.startsWith("//") && text.contains("\n")) {
            return text.substring(2, text.indexOf("\n"));
        }
        return null;
    }

    public static int toPositive(String text) throws RuntimeException {
        int number = -1;

        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
