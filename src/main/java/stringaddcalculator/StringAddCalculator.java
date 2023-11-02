package stringaddcalculator;

import stringaddcalculator.domain.PositiveInteger;
import stringaddcalculator.domain.PositiveIntegers;
import stringaddcalculator.support.Splitter;
import stringaddcalculator.validator.StringValidator;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int NULL_EMPTY_STRING_RESULT = 0;

    public static int splitAndSum(final String inputString) {
        if (StringValidator.isNullOrEmptyString(inputString)) {
            return NULL_EMPTY_STRING_RESULT;
        }

        if (StringValidator.isOneCharacterString(inputString)) {
            PositiveInteger positiveInteger = PositiveInteger.of(inputString);
            return positiveInteger.getNumber();
        }

        String[] strings = Splitter.splitInputString(inputString);
        PositiveIntegers positiveIntegers = PositiveIntegers.ofStringArray(strings);

        return positiveIntegers.sumAll();
    }
}
