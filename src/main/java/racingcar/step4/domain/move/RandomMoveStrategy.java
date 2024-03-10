package racingcar.step4.domain.move;

import java.util.Random;

import static racingcar.step4.utils.ConstUtils.MINIMUM_MOVE_BOUND;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        Random random = new Random();

        return MINIMUM_MOVE_BOUND <= random.nextInt(10);
    }
}
