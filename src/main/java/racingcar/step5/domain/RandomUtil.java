package racingcar.step5.domain;

import java.util.Random;

public class RandomUtil implements MoveStrategy {
    private static final Random random = new Random();
    private static final int BOUNDARY = 10;
    private static final int MOVABLE_CONDITION = 4;

    public static int generateRandomNumber() {

        return random.nextInt(BOUNDARY);
    }

    @Override
    public boolean movable() {
        return generateRandomNumber() >= MOVABLE_CONDITION;
    }
}
