package step3.domain;

public class RandomMoveRule implements MoveRule {

    public static final int NUMBER_CAN_MOVE = 4;

    public boolean canMove() {
        return isNumberCanMove(RandomNumberGenerator.generateRandomValue());
    }

    public static boolean isNumberCanMove(int randomValue) {
        return randomValue >= NUMBER_CAN_MOVE;
    }

}
