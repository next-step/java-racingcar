package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\n(.*)$";
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int INPUT_STRING_GROUP_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        List<String> inputList = splitByPattern(input);
        return sumInts(new CalculatorTargetInts(inputList).getList());
    }

    private static int sumInts(List<CalculatorTargetInt> ints) {
        int result = 0;

        for (CalculatorTargetInt val : ints) {
            result += val.getValue();
        }

        return result;
    }

    private static List<String> splitByPattern(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            return Arrays.asList((matcher.group(INPUT_STRING_GROUP_INDEX).split(customDelimiter)));
        }

        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }
}
