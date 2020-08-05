package com.hskim.nextstep.step03.utils;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    private RandomUtils() {

    }

    public static int getRandomInteger(int bound){

        return random.nextInt(bound);
    }
}
