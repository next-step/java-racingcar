package racingGame.game;

import java.util.Random;

public class CarForwardRule implements RacingGameRule {

    private static final int CAR_FORWARD_STANDARD = 4;

    @Override
    public boolean result() {
        return generateRandomNumber() >= CAR_FORWARD_STANDARD;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
