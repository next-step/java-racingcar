package racingcar.moving;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int BASE_LINE_NUM = 4;

    @Override
    public boolean isMovable() {
        return random() >= BASE_LINE_NUM;
    }

    private int random() {
        return new Random().nextInt(RandomMovingStrategy.MAX_NUM) + RandomMovingStrategy.MIN_NUM;
    }
}
