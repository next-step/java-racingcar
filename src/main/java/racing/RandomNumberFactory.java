package racing;

import java.util.Random;

public class RandomNumberFactory {

    public static Random random =  new Random();
    public static int MAX_NUMBER = 10;

    public static int createRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
