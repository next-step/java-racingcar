package stringaddcalculator;

import stringaddcalculator.support.IntegerParser;
import stringaddcalculator.validator.StringValidator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int NULL_EMPTY_STRING_RESULT = 0;
    private static final String BASE_SPLIT_REGEX = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(final String inputString) {
        if (StringValidator.isNullOrEmptyString(inputString)) {
            return NULL_EMPTY_STRING_RESULT;
        }

        if (StringValidator.isOneCharacterString(inputString)) {
            return IntegerParser.parsePositiveInteger(inputString);
        }

        String[] splitStrings = splitInputString(inputString);
        return sumStringArray(splitStrings);
    }

    private static String[] splitInputString(String inputString) {
        Matcher matcher = CUSTOM_PATTERN.matcher(inputString);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return inputString.split(BASE_SPLIT_REGEX);
    }

    private static int sumStringArray(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(IntegerParser::parsePositiveInteger)
                .sum();
    }
}
