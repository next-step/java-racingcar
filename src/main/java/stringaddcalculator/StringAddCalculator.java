package stringaddcalculator;

import stringaddcalculator.domain.PositiveIntegers;
import stringaddcalculator.support.Splitter;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int NULL_EMPTY_STRING_RESULT = 0;

    public static int splitAndSum(final String inputString) {
        if (isNullOrEmptyString(inputString)) {
            return NULL_EMPTY_STRING_RESULT;
        }

        String[] strings = Splitter.splitInputString(inputString);
        PositiveIntegers positiveIntegers = PositiveIntegers.ofStringArray(strings);

        return positiveIntegers.sumAll();
    }

    private static boolean isNullOrEmptyString(final String inputString) {
        return inputString == null || inputString.isEmpty();
    }
}
