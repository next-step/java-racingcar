package racingcar.step3.move;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final int MINIMUM_MOVE_BOUND = 4;

    @Override
    public boolean move() {
        Random random = new Random();

        return MINIMUM_MOVE_BOUND <= random.nextInt(10);
    }
}
