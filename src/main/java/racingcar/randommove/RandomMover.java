package racingcar.randommove;

import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.extension.Moveable;

public class RandomMover implements Moveable {

    private static final int DEFAULT_LEFT = 0;
    private static final int DEFAULT_RIGHT = 9;

    private final int left;
    private final int right;
    private final Random random;

    public static RandomMover newInstance() {
        return new RandomMover(DEFAULT_LEFT, DEFAULT_RIGHT);
    }

    RandomMover(int left, int right) {
        this.left = left;
        this.right = right;
        this.random = new Random();
    }

    @Override
    public boolean isMove() {
        return random.nextInt(right - left + 1) + left > Car.MOVE_RULE;
    }

}
