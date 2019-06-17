package camp.nextstep.edu.racingcar.domain;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;
    private static final int MOVE_UNIT = 1;
    private static final int STAY_UNIT = 0;

    @Override
    public Integer getDistanceToMove() {
        return RANDOM.nextInt(BOUND) >= THRESHOLD ? MOVE_UNIT : STAY_UNIT;
    }
}
