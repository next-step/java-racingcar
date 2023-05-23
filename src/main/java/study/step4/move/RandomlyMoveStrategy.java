package study.step4.move;

import java.util.Random;

public class RandomlyMoveStrategy implements MoveStrategy {

    private static final int TOTAL_NUMBER = 10;
    private static final int THRESHOLD_NUMBER = 4;


    @Override
    public boolean isSuccess() {
        final Random random = new Random();
        int randomNumber = random.nextInt(TOTAL_NUMBER);

        return randomNumber >= THRESHOLD_NUMBER;
    }
}
