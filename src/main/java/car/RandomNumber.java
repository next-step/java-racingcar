package car;

import java.util.Random;

public class RandomNumber {
    private static final int numberBound = 10;

    public static int getNumber() {
        Random random = new Random();
        return random.nextInt(numberBound);
    }
}
