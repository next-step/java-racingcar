package race;

import java.util.Random;

public class JudgeCarMovement {
    private final Random random;

    public JudgeCarMovement(Random random) {
        this.random = random;
    }

    public Judge judge() {
        int randomValue = random.nextInt(10);
        if(randomValue >= 4) {
            return Judge.FORWARD;
        }

        return Judge.STAY;
    }

    enum Judge {
        STAY, FORWARD
    }
}
