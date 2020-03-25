package racingGame.game;

import java.util.Random;

public class RandomStrategy implements MovingRule {

    private static final int CAR_FORWARD_STANDARD = 4;
    private static final int NUMBER_RANGE = 10;

    @Override
    public boolean isMove() {
        return generateRandomNumber() >= CAR_FORWARD_STANDARD;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(NUMBER_RANGE);
    }
}
