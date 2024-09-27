package com.warmup.step2;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if (isNullOrEmpty(input)) {
            return 0;
        }

        // 커스텀 delegate
        if (hasCustomDelegate(input)) {
            String[] splitDelegateAndNumberArr = input.split("\n");

            String delegateFromInput = extractedDelegateFromInput(splitDelegateAndNumberArr[0]);

            String[] splittedInput = splitDelegateAndNumberArr[1].split(delegateFromInput);

            return sumStringArray(splittedInput);
        }

        // 일반 delegate
        if (hasDelegateFromInput(input)) {
            String[] splittedInput = input.split("[,:]");

            return sumStringArray(splittedInput);
        }

        return Integer.parseInt(input.trim());
    }

    /**
     * Custom Delegate를 갖고 있는지 여부를 반환
     */
    private static boolean hasCustomDelegate(String newInput) {
        return newInput.startsWith("//") && newInput.contains("\n");
    }

    /**
     * 기본 Delegate를 포함하고 있는지 여부를 반환
     */
    private static boolean hasDelegateFromInput(String input) {
        List<String> delegateArr = Arrays.asList(",", ":");

        for (String delegate : delegateArr) {
            if (input.contains(delegate)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 구분자 문자열에서 불필요한 부분 삭제
     */
    private static String extractedDelegateFromInput(String delegate) {
        return delegate.replace("//", "")
                .replace("\\n", "");
    }

    /**
     * String Array의 값을 더하여 반환
     */
    private static int sumStringArray(String[] splittedInput) {
        int sumResult = 0;

        for (String s : splittedInput) {
            sumResult += safetyParseIntFromString(s);
        }

        return sumResult;
    }

    /**
     * String 값을 integer로 안전하게 변환
     */
    private static int safetyParseIntFromString(String input) {
        try {
            int parsedValue = Integer.parseInt(input);

            if (parsedValue < 0) {
                throw new RuntimeException("Invalid input: " + input);
            }

            return parsedValue;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unable to parse " + input + " as an integer");
        }

    }

    /**
     * string 문자열에 대해 Null, Empty 여부를 반환
     */
    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
