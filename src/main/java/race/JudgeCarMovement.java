package race;

import java.util.Random;

public class JudgeCarMovement {
    private final Random random;
    private final static int MOVE_THRESHOLD = 4;

    public JudgeCarMovement(Random random) {
        this.random = random;
    }

    public Judge judge() {
        int randomValue = random.nextInt(10);
        if (randomValue >= MOVE_THRESHOLD) {
            return Judge.MOVE;
        }

        return Judge.STAY;
    }

    enum Judge {
        STAY, MOVE
    }
}
