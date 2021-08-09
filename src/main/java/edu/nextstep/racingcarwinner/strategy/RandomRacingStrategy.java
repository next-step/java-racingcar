package edu.nextstep.racingcarwinner.strategy;

import java.util.Random;

public class RandomRacingStrategy implements RacingStrategy {
    private static final int MOVING_CRITERIA = 4;
    private static final int MAX_RANDOM_VALUE = 10;
    private static final Random random = new Random();

    @Override
    public boolean movable() {
        return getRandomNum() >= MOVING_CRITERIA;
    }

    public int getRandomNum(){
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
