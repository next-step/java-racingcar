package com.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final int NAME_LIMIT = 5;

    public static boolean isInvalidName(String name){
        return NAME_LIMIT < name.length();
    }

    public static List<String> parseCarNames(String line) {
        List<String> carNames = new ArrayList<>();
        String[] names = line.split(",");

        for (String name : names ) {
            name = name.trim();
            validateName(name);
            carNames.add(name);
        }
        return carNames;
    }

    private static void validateName(String name) {
        if ( isInvalidName(name) ) {
            throw new IllegalArgumentException(name + " is over limit");
        }
    }
}
