package step3;

import java.util.Random;

public class RandomUtil {

    public static int generateMoveValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
