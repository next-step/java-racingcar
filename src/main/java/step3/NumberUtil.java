package step3;

import java.util.Random;

public class NumberUtil {

    public static int generateRandomIntZeroToTen() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
