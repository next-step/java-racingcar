package step3.model;

import java.util.Random;

public class RandomGenerator {

    public static int generateRandomCount() {
        Random randomGenerator = new Random();

        return randomGenerator.nextInt(10);
    }
}
