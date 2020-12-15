package step3;

public class RandomMoveRule implements MoveRule {
    public static final int NUMBER_CAN_MOVE = 4;

    private RandomMoveRule() {
    }

    @Override
    public boolean canMove() {
        return canMoveWithNumber(RandomNumberGenerator.generate());
    }

    public static boolean canMoveWithNumber(int number) {
        return number >= NUMBER_CAN_MOVE;
    }
}
