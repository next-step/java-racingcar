package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MINIMUM_VALUE = 4;
    private static Random random;

    public RandomMoveStrategy() {
        random = new Random();
    }

    @Override
    public boolean isMove() {
        return generateRandomNumber() >= MINIMUM_VALUE;
    }

    public int generateRandomNumber() {
        return random.nextInt(10);
    }

}