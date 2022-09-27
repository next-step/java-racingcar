package racingcar.controller;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final Integer MIN_NUM = 0;
    private static final Integer MAX_NUM = 10;

    public Integer randomNumber() {
        return ThreadLocalRandom.current().nextInt(MIN_NUM, MAX_NUM);
    }
}
