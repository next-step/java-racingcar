package racingcar.domain;

import java.util.Random;

public class RandomNumberMoveStrategy implements MoveStrategy{
    private static final int MAX_FORWARD_NUMBER = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;

    @Override
    public boolean moveAble() {
        return getRandomNumber() >= MAX_FORWARD_NUMBER;
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_RANGE);
    }
}
