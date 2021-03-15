package new_racingcar.strategy;

import new_racingcar.util.RandomUtil;

public class MoveOneStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMoveable() {
        return MOVE_CONDITION <= RandomUtil.getValue();
    }
}
