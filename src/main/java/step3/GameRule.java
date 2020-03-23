package step3;

import java.util.Random;

public class GameRule {

    private static final int NUMBER_CAN_MOVE = 4;

    public boolean canMove() {
        return isNumberCanMove(generateRandomValue());
    }

    public static boolean isNumberCanMove(int randomValue) {
        return randomValue >= NUMBER_CAN_MOVE;
    }

    private static int generateRandomValue() {
        Random generator = new Random();

        int randomValue = generator.nextInt(10);
        ValidationUtils.isSingleDigitNumber(randomValue);

        return randomValue;
    }
}
