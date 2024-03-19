package racingCar;

import java.util.Random;

public class RandomRacingRule implements RacingRule{
    public static int MOVABLE_STANDARD = 4;
    public static int RANDOM_STANDARD = 10;

    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return generateRandomDistance() >= MOVABLE_STANDARD;
    }

    public static int generateRandomDistance(){
        return random.nextInt(RANDOM_STANDARD);
    }
}
