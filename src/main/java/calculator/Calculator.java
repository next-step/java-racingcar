package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final String REGEX = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        String[] texts = split(text);
        int[] ints = toNumbers(texts);
        return sum(ints);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String target = matcher.group(2);

            return target.split(customDelimiter);
        }

        String[] result = text.split(REGEX);
        return result;
    }

    private static int[] toNumbers(String[] texts) {
        int[] numbers = new int[texts.length];
        for (int i = 0; i < texts.length; i++) {
            numbers[i] = parse(texts[i]);
        }

        return numbers;
    }

    private static int parse(String text) {
        int number = Integer.parseInt(text);
        if (checkNegative(number)) {
            throw new RuntimeException();
        }

        return number;
    }

    private static boolean checkNegative(int number) {
       return number < 0;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
