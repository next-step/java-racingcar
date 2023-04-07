package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static final String COMMA_AND_SEMICOLON_REGEX = "[,;]";
    private static final Pattern SPACIAL_CHARACTER_PATTERN;
    private static final int ZERO = 0;

    static {
        SPACIAL_CHARACTER_PATTERN = Pattern.compile("//(.)\n(.*)");
    }

    public static int splitAndSum(String input) {
        if (isBlank(input)) return ZERO;

        return addition(parseInts(splitNumberBySpacialText(input)));
    }

    public static int onlyNumberSplitAndSum(String input) {
        if (isBlank(input)) return ZERO;

        validateSpacialCharacter(input);
        validateNegativeNumber(input);

        return addition(parseInts(splitNumberBySpacialText(input)));
    }

    private static void validateSpacialCharacter(String input) {
        boolean isSpacialCharacter = SPACIAL_CHARACTER_PATTERN.matcher(input).find();
        if (isSpacialCharacter) {
            throw new RuntimeException("특수문자를 입력할 수 없습니다.");
        }
    }

    private static void validateNegativeNumber(String input) {
        final String MINUS = "-";
        boolean isNegative = input.contains(MINUS);
        if (isNegative) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int addition(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }

    private static int[] parseInts(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(StringSumCalculator::parseInt)
                .toArray();
    }

    private static int parseInt(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            result = 0;
        }
        return result;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitNumberBySpacialText(String input) {
        Matcher matcher = SPACIAL_CHARACTER_PATTERN.matcher(input);
        if (matcher.find()) {
            String text = matcher.group(2);
            String separator = matcher.group(1);
            return text.split(separator);
        }

        return input.split(COMMA_AND_SEMICOLON_REGEX);
    }

}
