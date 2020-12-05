package step3;

import java.util.Random;

public class RandomNumberProvider {
    private static Random random = new Random();

    public static int provideRandomNumber() {
        return random.nextInt(10);
    }
}
