package com.next.step.step2;

import java.util.Arrays;

public class SumNumber {

    public static int sumSplitNumbers(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .peek(StringCalculatorValidation::validateNumber)
                .mapToInt(Integer::parseInt)
                .peek(StringCalculatorValidation::validateNegativeValue)
                .sum();
    }
}
