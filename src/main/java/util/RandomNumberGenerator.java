package util;

import java.util.Random;

public class RandomNumberGenerator {
    public static Integer getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
