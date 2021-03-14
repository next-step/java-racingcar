package racingcar.service;

import java.util.Random;


public class RandomMoveStrategy implements MoveStrategy {
    Random random = new Random();
    private final int maxRandomNum = 10;
    private final int moveCondition = 4;

    private int generateRandomNumber() {
        return random.nextInt(maxRandomNum);
    }

    @Override
    public Boolean getIsMove() {
        int moveNum = generateRandomNumber();
        return moveNum >= moveCondition;
    }
}
