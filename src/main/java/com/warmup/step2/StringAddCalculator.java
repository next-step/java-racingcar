package com.warmup.step2;

public class StringAddCalculator {

    static public int splitAndSum(String input) {
        if(isNullOrEmpty(input)){
            return 0;
        }

        return Integer.parseInt(input.trim());
    }

    /**
     * string 문자열에 대해 Null, Empty 여부를 반환
     */
    static private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
