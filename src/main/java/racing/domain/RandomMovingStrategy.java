package racing.domain;

import racing.domain.enums.MoveStatus;
import racing.util.NumberUtil;

public class RandomMovingStrategy implements IMovingStrategy {

    private static final int MAX_MOVABLE_RANGE = 9;

    @Override
    public boolean isMovable() {
        return MoveStatus.GO == MoveStatus.findByNumber(NumberUtil.generateRandomNumberFromZeroToInputNumber(MAX_MOVABLE_RANGE));
    }

}
