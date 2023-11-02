package stringaddcalculator;

import stringaddcalculator.support.IntegerParser;
import stringaddcalculator.validator.StringValidator;

import java.util.Arrays;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int NULL_EMPTY_STRING_RESULT = 0;

    public static int splitAndSum(final String inputString) {
        if (StringValidator.isNullOrEmptyString(inputString)) {
            return NULL_EMPTY_STRING_RESULT;
        }

        if (StringValidator.isOneCharacterString(inputString)) {
            return IntegerParser.parsePositiveInteger(inputString);
        }

        String[] splitStrings = Splitter.splitInputString(inputString);
        return sumStringArray(splitStrings);
    }



    private static int sumStringArray(String[] splitStrings) {
        return Arrays.stream(splitStrings)
                .mapToInt(IntegerParser::parsePositiveInteger)
                .sum();
    }
}
