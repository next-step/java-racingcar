package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculate(String text) {
        if (text.contains("-")) {
            throw new RuntimeException();
        }

        if (text == null || text.isBlank()) {
            return 0;
        }

        if (text.contains(",") || text.contains(":") || text.length() == 1) {
            return sum(parse(text));
        }
        return sum(customParse(match(text)));
    }

    private static int sum(String[] numbers) {
        int number = 0;
        for (String s : numbers) {
            number += Integer.parseInt(s);
        }
        return number;
    }

    private static String[] parse(String text) {
        return text.split("[,≠:]");
    }

    private static String[] customParse(Matcher matcher) {
        String[] tokens = null;
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            tokens = matcher.group(2).split(customDelimiter);
        }
        return tokens;
    }

    private static Matcher match(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

}
