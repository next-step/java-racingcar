package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private Random random;

    public RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(10) >= 4;
    }
}
