package racing_car.step03;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();
    private static final int BORDER = 10;

    public static int generateRandomNumber() {
        return random.nextInt(BORDER);
    }
}
