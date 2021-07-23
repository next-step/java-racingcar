package edu.nextstep.racingcar.step3.util;

import java.util.Random;

public class RandomUtils implements Randoms {

    @Override
    public Integer getRandomNumber(Integer numberOfRandoms) {
        Random random = new Random();
        return random.nextInt(numberOfRandoms);
    }
}
