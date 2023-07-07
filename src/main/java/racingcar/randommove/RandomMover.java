package racingcar.randommove;

import racingcar.domain.extension.Moveable;

import java.util.Random;

public class RandomMover implements Moveable {

    public static final int DEFAULT_LEFT = 0;
    public static final int DEFAULT_RIGHT = 9;
    public static final int MOVE_RULE = 3;
    private final int left;
    private final int right;
    private final int moveRule;
    private final Random random;

    public static RandomMover newInstance() {
        return new RandomMover(DEFAULT_LEFT, DEFAULT_RIGHT, MOVE_RULE);
    }

    RandomMover(int left, int right, int moveRule) {
        this.left = left;
        this.right = right;
        this.moveRule = moveRule;
        this.random = new Random();
    }

    @Override
    public boolean isMove() {
        return random.nextInt(right - left + 1) + left > moveRule;
    }

}
