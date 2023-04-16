package step3;

import java.util.Random;

public class RacingCar {

    public static final int LIMIT = 4;
    public static final int RANDOM_LIMIT = 10;
    public boolean isValueMoreThan(int value) {
        return value >= LIMIT;
    }
    public int randomValue() {
        Random random = new Random();
        int value = random.nextInt(RANDOM_LIMIT);
        return value;
    }
}
