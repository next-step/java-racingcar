package com.warmup.step2;

public class StringAddCalculator {

    static public int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        if (input.contains(",")) {
            String[] splittedInput = input.split(",");

            return sumStringArray(splittedInput);
        }

        return Integer.parseInt(input.trim());
    }

    /**
     * String Array의 값을 Integer로 변환하여 반환
     */
    private static int sumStringArray(String[] splittedInput) {
        int result = 0;

        for (String s : splittedInput) {
            result += Integer.parseInt(s);
        }

        return result;
    }

    /**
     * string 문자열에 대해 Null, Empty 여부를 반환
     */
    static private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
