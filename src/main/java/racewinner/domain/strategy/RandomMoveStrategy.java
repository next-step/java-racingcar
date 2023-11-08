package racewinner.domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        final int number = new Random().nextInt(10);
        return number > 4;
    }
}
