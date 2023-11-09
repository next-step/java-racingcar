package racingcar.domain.game.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int BASE_RANDOM_BOUND = 10;
    private static final int MOVE_CONDITION = 4;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean movable() {
        int randomNumber = random.nextInt(BASE_RANDOM_BOUND);

        return randomNumber >= MOVE_CONDITION;
    }
}
