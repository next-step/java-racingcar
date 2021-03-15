package carRacing.util;

import java.util.Random;

public class RandomIntUtil {
    public static int getRandomInt(){
        Random random = new Random();
        return random.nextInt(10);
    }
}
