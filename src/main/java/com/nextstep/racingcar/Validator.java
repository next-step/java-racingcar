package com.nextstep.racingcar;

public class Validator {
    private static final int NAME_LIMIT = 5;

    public static boolean isInvalidName(String name){
        return NAME_LIMIT < name.length();
    }
}
