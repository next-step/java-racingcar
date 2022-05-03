package racing;

import java.util.Random;

public class RandomNumberGenerator {
    private static int BOUND = 10;
    private static Random random = new Random();

    public static int getRandomInt(){
        return random.nextInt(BOUND);
    }

}
