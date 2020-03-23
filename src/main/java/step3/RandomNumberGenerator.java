package step3;

import java.util.Random;

public class RandomNumberGenerator {

    public static int generateRandomValue() {
        Random generator = new Random();

        int randomValue = generator.nextInt(10);
        ValidationUtils.isSingleDigitNumber(randomValue);

        return randomValue;
    }
}
