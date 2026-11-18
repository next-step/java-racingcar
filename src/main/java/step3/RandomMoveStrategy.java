package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD_THRESHOLD = 4;

    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        int randomNumber = random.nextInt(RANDOM_BOUND); // 0 이상 10 미만 (0~9)
        return randomNumber >= FORWARD_THRESHOLD;
    }
}
