package com.nextstep.racingcar;

public class CarName {
    private static final int NAME_LIMIT = 5;

    private String name;

    public CarName(String name) {
        if (isInvalidName(name)) {
            throw new IllegalArgumentException(name + " is over limit");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isInvalidName(String name){
        return NAME_LIMIT < name.length();
    }
}
