package car.domain;

import java.util.Random;

public class RandomNumber {
    public static int getRandomNumber(int maxNum) {
        Random random = new Random();
        return random.nextInt(maxNum);
    }
}
