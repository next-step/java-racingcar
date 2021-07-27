package edu.nextstep.racingcar.step4.domain;

import edu.nextstep.racingcar.step4.util.RandomUtils;

public class CarStrategy {

    public static MoveStrategy getMoveStrategy(int numberOfRandoms, int threshold) {
        return () -> {
            RandomUtils randomUtils = new RandomUtils(numberOfRandoms);
            return randomUtils.getRandomNumber() >= threshold;
        };
    }
}
