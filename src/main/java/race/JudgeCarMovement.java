package race;

import java.util.Random;

public class JudgeCarMovement {
    private final Random random;

    public JudgeCarMovement(Random random) {
        this.random = random;
    }

    public boolean judge() {
        int randomValue = random.nextInt(10);
        return randomValue >= 4;
    }
}
