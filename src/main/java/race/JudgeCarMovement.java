package race;

import java.util.Random;

public class JudgeCarMovement {
    private final static int RANDOM_VALUE_BOUND = 10;
    private final static int MOVE_THRESHOLD = 4;
    private final Random random;

    public JudgeCarMovement(Random random) {
        this.random = random;
    }

    public Judge judge() {
        int randomValue = random.nextInt(RANDOM_VALUE_BOUND);
        if (randomValue >= MOVE_THRESHOLD) {
            return Judge.MOVE;
        }

        return Judge.STAY;
    }

    enum Judge {
        STAY, MOVE
    }
}
