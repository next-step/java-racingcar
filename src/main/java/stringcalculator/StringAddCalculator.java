package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndAdd(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return add(split(parseInputExpression(input)));
    }

    private static int add(String[] stringNumberArray) {
        return Arrays.stream(stringNumberArray).mapToInt(StringAddCalculator::parseInt).sum();
    }

    private static int parseInt(String maybeNumberString) {
        try {
            int parsedValue = Integer.parseInt(maybeNumberString);

            if (parsedValue < 0) {
                throw new RuntimeException();
            }

            return parsedValue;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static String[] split(Input input) {
        return input.getInput().split(input.getDelimiter());
    }

    private static boolean hasCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        return matcher.find();
    }

    private static String getCustomDelimiterOrElseThrow(String input) {
        if (hasCustomDelimiter(input)) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }

        throw new DelimiterNotFoundException();
    }

    private static String removeCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            return matcher.group(2);
        }

        return input;
    }

    public static String getValidInput(String input) {
        if (hasCustomDelimiter(input)) {
            return removeCustomDelimiter(input);
        }

        return input;
    }

    public static Input parseInputExpression(String input) {
        if (hasCustomDelimiter(input)) {
            return new Input(input, getValidInput(input), getCustomDelimiterOrElseThrow(input));
        }

        return Input.hasNoDelimiter(input);
    }
}
