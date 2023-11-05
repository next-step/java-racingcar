package racewinner.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMoved() {
        final int number = new Random().nextInt(10);
        if (number >= 4) {
            return true;
        }

        return false;
    }
}
