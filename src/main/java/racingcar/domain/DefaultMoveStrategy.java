package racingcar.domain;

import java.util.Random;

public class DefaultMoveStrategy implements MoveStrategy {
    public static Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RacingGameConstant.RANDOM_LIMIT) >= RacingGameConstant.MOVE_CONDITION;
    }
}
