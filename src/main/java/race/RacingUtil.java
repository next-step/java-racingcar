package race;

import java.util.Random;

public class RacingUtil {
    private static final Random random = new Random();

    public static int generateRandomNum() {
        return random.nextInt(10);
    }
}
