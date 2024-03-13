package racingCar;

import java.util.Random;

public class RacingRule {
    public static int MOVABLE_STANDARD = 4;
    public static int RANDOM_STANDARD = 10;

    private static Random random = new Random();

    public static boolean isMovable(int distance) {
        return distance >= MOVABLE_STANDARD;
    }

    public static int generateRandomDistance(){
        return random.nextInt(RANDOM_STANDARD);
    }
}
