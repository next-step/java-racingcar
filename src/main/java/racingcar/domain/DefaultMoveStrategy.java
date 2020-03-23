package racingcar.domain;

import java.util.Random;

import static racingcar.domain.RacingGameConstant.MOVE_CONDITION;
import static racingcar.domain.RacingGameConstant.RANDOM_LIMIT;

public class DefaultMoveStrategy implements MoveStrategy {
    public static Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_LIMIT) >= MOVE_CONDITION;
    }
}
