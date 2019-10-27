package game.racing;

import java.util.Random;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class CarMover {

    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;
    private static Random random = new Random();

    public static boolean movable() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
