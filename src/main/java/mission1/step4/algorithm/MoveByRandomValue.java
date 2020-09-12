package mission1.step4.algorithm;

import java.util.Random;

public class MoveByRandomValue implements MoveStrategy{

    private static final int PROGRESS_CONDITION = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean movable() {
        if (RANDOM.nextInt(10) >= PROGRESS_CONDITION) {
            return true;
        }

        return false;
    }
}





