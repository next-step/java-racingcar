package edu.nextstep.racingcar.step4.domain;

import edu.nextstep.racingcar.step4.util.RandomUtils;

public class CarStrategy implements MoveStrategy {

    @Override
    public boolean isMove(int numberOfRandoms, int threshold) {
        RandomUtils randomUtils = new RandomUtils(numberOfRandoms);
        return randomUtils.getRandomNumber() >= threshold;
    }
}
