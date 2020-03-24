package step3;

import java.util.*;

public class GameRule {

    public static final int NUMBER_CAN_MOVE = 4;

    public static boolean canMove() {
        return isNumberCanMove(RandomNumberGenerator.generateRandomValue());
    }

    public static boolean isNumberCanMove(int randomValue) {
        return randomValue >= NUMBER_CAN_MOVE;
    }

    public static int getMaxPosition(List<Integer> finalPositionList) {
        return Collections.max(finalPositionList);
    }

}
