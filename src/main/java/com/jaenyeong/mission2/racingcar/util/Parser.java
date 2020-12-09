package com.jaenyeong.mission2.racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SEPARATOR = ",";
    private static final String DASH = "-";

    public static List<String> separateInputBySeparator(final String input) {
        return Arrays.asList(input.split(SEPARATOR));
    }

    public static String parseToPrintFormatFromRacingHistory(final String carName, final int distance) {
        final StringBuilder sb = new StringBuilder();
        sb.append(carName)
            .append(" : ");

        for (int i = 0; i < distance; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
