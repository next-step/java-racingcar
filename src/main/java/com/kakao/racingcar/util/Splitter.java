package com.kakao.racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private static final String COMMA_DELIMITER = ",";

    private Splitter() {
    }

    public static List<String> splitWithComma(String userName) {
        return Arrays.stream(userName.split(COMMA_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
