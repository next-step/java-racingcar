package step3;

import java.util.Random;

public class Utils {
    public static int getRandomNumber(int bound) {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
