package game.racing.domain;

import java.util.Random;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class CarMover {

    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;
    private static Random random = new Random();
    private static MoveStrategy DEFAULT_STRATEGY = (number, threshold) -> number >= threshold;

    public static boolean movable() {
        return movable(DEFAULT_STRATEGY, generateRandomNumber(), THRESHOLD);
    }

    public static boolean movable(int number) {
        return movable(DEFAULT_STRATEGY, number, THRESHOLD);
    }

    public static boolean movable(MoveStrategy strategy, int number, int threshold) {
        return strategy.movable(number, threshold);
    }

    private static int generateRandomNumber() {
        return random.nextInt(BOUND);
    }

}
