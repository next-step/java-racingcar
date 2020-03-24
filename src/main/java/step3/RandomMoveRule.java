package step3;

import java.util.*;

public class RandomMoveRule implements MoveRule {

    public static final int NUMBER_CAN_MOVE = 4;

    public boolean canMove() {
        return isNumberCanMove(RandomNumberGenerator.generateRandomValue());
    }

    private static boolean isNumberCanMove(int randomValue) {
        return randomValue >= NUMBER_CAN_MOVE;
    }

    //TODO: Move와 상관없음. 이관 대상.
    public static int getMaxPosition(List<Integer> finalPositions) {
        return Collections.max(finalPositions);
    }

}
