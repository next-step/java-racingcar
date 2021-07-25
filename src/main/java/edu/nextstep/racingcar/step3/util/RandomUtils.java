package edu.nextstep.racingcar.step3.util;

import java.util.Random;

public class RandomUtils implements Randoms {

    private final int numberOfRandoms;

    public RandomUtils(Integer numberOfRandoms) {
        this.numberOfRandoms = numberOfRandoms;
    }

    @Override
    public Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(numberOfRandoms);
    }

    @Override
    public Integer getNumberOfRandoms() {
        return numberOfRandoms;
    }
}
