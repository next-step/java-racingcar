package edu.nextstep.racingcar.step4.util;

import java.util.Random;

public class RandomUtils {

    private final int numberOfRandoms;

    public RandomUtils(int numberOfRandoms) {
        this.numberOfRandoms = numberOfRandoms;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(numberOfRandoms);
    }
}
