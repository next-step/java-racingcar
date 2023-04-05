package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    static final String SPACIAL_CHARACTER_REGEX = "//(.)\n(.*)";
    static final String COMMA_AND_SEMICOLON_REGEX = ",|;";

    public static int splitAndSum(String input) {
        int result = 0;
        if (isBlank(input)) return result;

        String[] numbers = splitNumberBySpacialText(input);
        return addition(numbers);
    }

    public static int splitAndSumThrows(String input) {
        if (isBlank(input)) return 0;

        validateSpacialCharacter(input);
        validateNegativeNumber(input);

        String[] numbers = input.split(COMMA_AND_SEMICOLON_REGEX);
        return addition(numbers);
    }

    private static void validateSpacialCharacter(String input) {
        boolean isSpacialCharacter = Pattern.compile(SPACIAL_CHARACTER_REGEX).matcher(input).find();
        if (isSpacialCharacter) {
            throw new RuntimeException("Matcher spacial character number");
        }
    }

    private static void validateNegativeNumber(String input) {
        boolean isNegative = input.contains("-");
        if (isNegative) {
            throw new RuntimeException("Contains negative");
        }
    }

    private static int addition(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result = sum(result, parseInt(number));
        }
        return result;
    }

    private static int sum(int a, int b) {
        return a + b;
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
        Matcher matcher = Pattern.compile(SPACIAL_CHARACTER_REGEX).matcher(input);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return input.split(COMMA_AND_SEMICOLON_REGEX);
    }

}
