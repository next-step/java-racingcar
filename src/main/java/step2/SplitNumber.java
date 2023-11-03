package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitNumber {

    private static final String DEFAULT_SEPARATOR_PATTERN = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int[] splitNumbers(final String input) {
        return parseIntegerArray(splitInput(input));
    }

    private static String[] splitInput(final String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return input.split(DEFAULT_SEPARATOR_PATTERN);
    }

    private static int[] parseIntegerArray(final String[] splitNumbers) {
        return Arrays.stream(splitNumbers).mapToInt(SplitNumber::parseInt).toArray();
    }

    private static int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Input Number");
        }
    }
}
