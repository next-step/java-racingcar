package racingcar.moving;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MAX_NUM = 9;
    static final int BASE_LINE_NUM = 4;

    private final Random random;

    public RandomMovingStrategy() {
        this(new Random());
    }

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMovable() {
        return random() >= BASE_LINE_NUM;
    }

    private int random() {
        return random.nextInt(MAX_NUM + 1);
    }
}
