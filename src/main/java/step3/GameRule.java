package step3;

import java.util.*;

public class GameRule {

    private static final int NUMBER_CAN_MOVE = 4;

    public boolean canMove() {
        return isNumberCanMove(RandomNumberGenerator.generateRandomValue());
    }

    public static boolean isNumberCanMove(int randomValue) {
        return randomValue >= NUMBER_CAN_MOVE;
    }

    public int getMaxPosition(List<Integer> finalPositionList) {
        return Collections.max(finalPositionList);
    }

}
