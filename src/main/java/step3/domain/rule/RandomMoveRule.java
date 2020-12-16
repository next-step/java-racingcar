package step3.domain.rule;

import step3.util.RandomNumberGenerator;

public class RandomMoveRule implements MoveRule {
    public static final int NUMBER_CAN_MOVE = 4;

    @Override
    public boolean canMove() {
        return canMoveWithNumber(RandomNumberGenerator.generate());
    }

    public static boolean canMoveWithNumber(int number) {
        return number >= NUMBER_CAN_MOVE;
    }
}
