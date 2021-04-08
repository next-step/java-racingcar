package racingcar.strategies;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    public static final int MIN_MOVE_CONDITION = 4;
    private static final int ROUND_10 = 10;
    private static Random random;

    @Override
    public boolean checkMovement() {
        return generateRandomNum() >= MIN_MOVE_CONDITION;
    }

    private static int generateRandomNum() {
        if (random == null) {
            random = new Random();
        }

        return random.nextInt(ROUND_10);
    }

}
