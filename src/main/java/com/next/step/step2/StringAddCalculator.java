package com.next.step.step2;

import static com.next.step.step2.StringSplit.splitInput;
import static com.next.step.step2.SumNumber.sumSplitNumbers;

public class StringAddCalculator {

    private static final int NULL_EMPTY_RETURN_VALUE = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_EMPTY_RETURN_VALUE;
        }

        return sumSplitNumbers(splitInput(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
