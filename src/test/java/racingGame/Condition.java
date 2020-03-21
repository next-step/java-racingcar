package racingGame;

import java.util.Random;

public class Condition {

    private static final int STANDARD_NUMBER = 4;

    private boolean status;

    public void init() {
        initStatus(generateRandomNumber());
    }

    public void initStatus(int randomNumber) {
        status = randomNumber >= STANDARD_NUMBER;
    }

    public boolean isOk() {
        return status;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
