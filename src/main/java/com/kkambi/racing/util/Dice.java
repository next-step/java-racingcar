package com.kkambi.racing.util;

import com.kkambi.racing.domain.Bound;

import java.util.Random;

public class Dice {

    private static final Random random = new Random();

    public static int roll(Bound bound) {
        return random.nextInt(bound.getValue());
    }
}
