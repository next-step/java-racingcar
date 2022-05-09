package racingcarwinnerrefactor.util;

import java.util.Random;

public class MoveStrategy implements Strategy{

    private static final Random random = new Random();
    public static final int RANDOM_MAX = 9;
    public static final int GO_MIN = 4;
    public static final int GO_MAX = 9;

    @Override
    public boolean isMovable() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= GO_MIN && randomNumber <= GO_MAX;
    }

    private int generateRandomNumber() {
        return random.nextInt(RANDOM_MAX);
    }
}
