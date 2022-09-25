package car_racing;


import java.util.Random;

public class GameRule {
    public static int RANDOM_LIMIT = 10;
    public static int STRAIGHT_CRITERIA = 4;
    private static final Random random = new Random();

    public static boolean isGoStraight(int number) {
        return number >= STRAIGHT_CRITERIA;
    }

    public static int pickRandom() {
        return random.nextInt(RANDOM_LIMIT);
    }
}
