package racingGame;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final Random random = new Random();

    @Override
    public boolean movable() {
        return random.nextInt(10) >= 4;
    }

}
