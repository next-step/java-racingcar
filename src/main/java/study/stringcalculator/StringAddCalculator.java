package study.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        String separator = getSeparator(text);
        String numberString = getNumberText(text, separator);
        String[] stringNumbers = splitNumbers(numberString, separator);
        int[] numbers = convertToIntegers(stringNumbers);
        return sumNumbers(numbers);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String getSeparator(String text) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_SEPARATOR;
    }

    private static String getNumberText(String text, String separator) {
        if (separator.equals(DEFAULT_SEPARATOR)) {
            return text;
        }

        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (m.find()) {
            return m.group(2);
        }

        return text;
    }

    private static String[] splitNumbers(String numberText, String separator) {
        return numberText.split(separator);
    }

    private static int[] convertToIntegers(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .filter(s -> !s.isEmpty())
                .mapToInt(StringAddCalculator::parseAndValidateNumber)
                .toArray();
    }

    private static int sumNumbers(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }

        return total;
    }

    private static int parseAndValidateNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다: ");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }
}
