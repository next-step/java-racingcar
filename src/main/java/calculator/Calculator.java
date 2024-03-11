package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String REGEX_CUSTOM_DELIMITER = "//(.*)\n(.*)";
    private static final int EMPTY = 0;

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return EMPTY;
        }

        return sum(toInts(convertStringToStrings(text)));
    }

    private static String[] convertStringToStrings(String text) {
        String[] strings = splitCustom(text);
        if (!isEmpty(strings)) {
            return strings;
        }
        return split(text);
    }

    private static boolean isEmpty(String[] strings) {
        return strings.length == 0;
    }

    private static String[] split(String text) {
        return text.split("[,:]");
    }

    private static String[] splitCustom(String text) {
        Matcher matcher = Pattern.compile(REGEX_CUSTOM_DELIMITER).matcher(text);
        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return new String[]{};
    }

    private static Boolean isEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] strings) {
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            isValidNumber(strings[i]);
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static void isValidNumber(String text) {
        try {
            int number = Integer.parseInt(text);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }
    }
}
