package game.racing;

import java.util.Random;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class CarMover {

    private static final int BOUND = 10;
    private static Random random = new Random();

    public static boolean movable(int threshold) {
        return movable(generateRandomNumber(), threshold);
    }

    public static boolean movable(int randomNumber, int threshold) {
        return randomNumber >= threshold;
    }

    private static int generateRandomNumber() {
        return random.nextInt(BOUND);
    }

}
