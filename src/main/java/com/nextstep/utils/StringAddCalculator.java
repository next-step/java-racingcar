package com.nextstep.utils;

public class StringAddCalculator {

    public static Integer splitAndSum(String text) {
        if(isEmptyText(text)) return 0;

        return -1;
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}
