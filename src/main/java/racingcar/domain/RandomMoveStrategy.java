package racingcar.domain;


import java.util.concurrent.ThreadLocalRandom;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int STEP_HURDLE = 4;

    @Override
    public boolean isMovable() {

        return STEP_HURDLE < ThreadLocalRandom.current().nextInt(1, 10) ;
    }
}
