package com.nextstep.racingcar.domain;

import java.util.Random;

public class Power {
    private static final Random random = new Random();
    private final int value;

    private Power(int value) {
        this.value = value;
    }

    public static Power generate() {
        return new Power(random.nextInt(10));
    }

    public static Power generateByInt(int value) {
        return new Power(value);
    }

    public int toInt() {
        return this.value;
    }
}
