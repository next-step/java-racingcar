package racing.rule;

import java.util.Random;

public class RandomMoveRule {
    private static final Random RANDOM = new Random();

    public static final int MAX_RANDOM_VALUE = 9; // random 최대값
    public static final int MIN_MOVE_VALUE = 4; // 전진하기 위한 최소값

    public boolean isMovable(int value) {
        return value >= MIN_MOVE_VALUE;
    }

    public boolean isMovableByRandomValue() {
        return isMovable(getRandomValue());
    }

    private int getRandomValue() {
        return RANDOM.nextInt(MAX_RANDOM_VALUE);
    }
}