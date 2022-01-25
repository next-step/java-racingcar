package racingcar;

import java.util.Random;

public class MoveCar {

    private static final int MIN_MOVE = 0;
    private static final int MAX_MOVE = 9;
    private static final int MOVABLE = 4;
    private static final Random random = new Random();

    public boolean isMove() {
        return randomMove() >= MOVABLE;
    }

    private int randomMove() {
        return MIN_MOVE + random.nextInt(MAX_MOVE - MIN_MOVE + 1);
    }

}
