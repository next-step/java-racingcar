package CarRacing;

import java.util.Random;

public class RandomValue {

    public static int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

}