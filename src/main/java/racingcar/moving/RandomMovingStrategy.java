package racingcar.moving;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MAX_NUM = 9;
    private static final int BASE_LINE_NUM = 4;

    @Override
    public boolean isMovable() {
        return random() >= BASE_LINE_NUM;
    }

    private int random() {
        return new Random().nextInt(MAX_NUM + 1);
    }
}
