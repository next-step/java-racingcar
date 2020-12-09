package com.jaenyeong.mission2.racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static final String SEPARATOR = ",";

    public static List<String> separateInputBySeparator(final String input) {
        return Arrays.asList(input.split(SEPARATOR));
    }
}
