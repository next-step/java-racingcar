package racinggame.domain.rule;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements MoveStrategy {

    private final int RANDOM_BOUND = 10;
    private final int MIN_MOVEMENT_VALUE = 4;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();


    @Override
    public boolean moveRule() {
        return random.nextInt(RANDOM_BOUND) >= MIN_MOVEMENT_VALUE;
    }
}
