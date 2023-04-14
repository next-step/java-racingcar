package car.step2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String COMMA_AND_COLON_REGEX = ",|:";
    private static final String INPUT_REGEX = "//(.)\n(.*)";
    public static int splitAndSum(String text) {
        if(text == null) {
            return 0;
        }
        if(text.isBlank()) {
            return 0;
        }

        if(isInteger(text)) {
            return Integer.parseInt(text);
        }

        String[] textList = split(text);
        return sum(textList);

    }

    private static boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[] split(String text) {
        if(text.startsWith("//")) {
            return splitRegex(text);
        }
        return text.split(COMMA_AND_COLON_REGEX);
    }

    private static String[] splitRegex(String text) {
        Matcher m = Pattern.compile(INPUT_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return null;
    }

    private static int sum(String[] textList) {
        int startNumber = 0;
        for (String text : textList) {
            int number = Integer.parseInt(text);
            isNegative(number);
            startNumber += number;
        }
        return startNumber;
    }

    private static void isNegative(int number) {
        if(number < 0) {
            throw new RuntimeException();
        }
    }
}
