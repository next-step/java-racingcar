package com.nextstep.racingcar.util;

import java.util.Arrays;
import java.util.List;

public class DriverNameParser {
    public static List<String> toUserNameList(String testInput) {
        String[] split = testInput.split(",");
        return Arrays.asList(split);
    }
}
