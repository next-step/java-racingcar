package study.step4.move;

import java.util.Random;

public class RandomlyMoveStrategy implements MoveStrategy {
    @Override
    public boolean isSuccess() {
        final Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber >= 4;
    }
}
