package edu.nextstep.racingcar.strategy;

import java.util.Random;

public class RandomStrategy implements RacingStrategy {
    private static final int CRITERIA = 4;
    private static final int MAX_RANDOM_VALUE = 10;

    @Override
    public boolean canMove() {
        return (getRandomNum() >= CRITERIA);
    }

    private int getRandomNum() {
        Random randomUtil = new Random();
        return randomUtil.nextInt(MAX_RANDOM_VALUE);
    }
}
