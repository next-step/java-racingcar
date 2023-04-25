package study;

import java.util.Random;

public class RacingCarUtil {
    public static int getRandomNumberZeroToNine() {

        Random random = new Random();
        int zeroToNineRandomNumber = random.nextInt(10);

        return zeroToNineRandomNumber;

    }
}
