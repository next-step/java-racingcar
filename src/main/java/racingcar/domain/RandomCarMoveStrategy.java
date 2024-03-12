package racingcar.domain;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {

    private final static Random RANDOM = new Random();
    private final static int RANDOM_BOUND = 10;
    private final static int MOVE_BOUND = 4;

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(RANDOM_BOUND) >= MOVE_BOUND;
    }

}
