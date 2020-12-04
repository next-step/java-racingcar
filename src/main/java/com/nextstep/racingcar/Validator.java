package com.nextstep.racingcar;

public class Validator {
    private static final int NAME_LIMIT = 5;

    public static boolean isValidName(String name){
        return name.length() <= NAME_LIMIT;
    }
}
