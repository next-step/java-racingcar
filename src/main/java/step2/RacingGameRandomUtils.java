package step2;

import java.util.Random;

public class RacingGameRandomUtils {
    private static final Random random = new Random();

    private RacingGameRandomUtils() {}

    public static boolean isMove() {
        return random.nextInt(10) >= 4;
    }

}
