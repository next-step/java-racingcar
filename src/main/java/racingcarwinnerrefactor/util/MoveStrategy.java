package racingcarwinnerrefactor.util;

import racingcarwinnerrefactor.Constants;

import java.util.Random;

public class MoveStrategy implements Strategy{

    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= Constants.GO_MIN && randomNumber <= Constants.GO_MAX;
    }

    private int generateRandomNumber() {
        return random.nextInt(Constants.RANDOM_MAX);
    }
}
