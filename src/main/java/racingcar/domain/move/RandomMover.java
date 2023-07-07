package racingcar.domain.move;

import java.util.Random;

public class RandomMover implements Moveable {

    private static RandomMover randomMover = null;
    public static final int DEFAULT_LEFT = 0;
    public static final int DEFAULT_RIGHT = 9;
    public static final int DEFAULT_MOVE_RULE = 3;
    private final int left;
    private final int right;
    private final int moveRule;
    private final Random random;

    public synchronized static RandomMover getInstance() {
        if (randomMover == null) {
            randomMover = new RandomMover(DEFAULT_LEFT, DEFAULT_RIGHT, DEFAULT_MOVE_RULE);
        }
        return randomMover;
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
