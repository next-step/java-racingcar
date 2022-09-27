package carRacing;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static int generateRandomNumber(int range){
        return random.nextInt(range);
    }
}
