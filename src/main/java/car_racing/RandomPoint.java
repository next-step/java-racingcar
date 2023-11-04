package car_racing;

import java.util.Random;

public class RandomPoint {
    public static final Random random = new Random();

    public static int getPoint() {
        return random.nextInt(10);
    }
}
