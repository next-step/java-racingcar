package step3;

import java.util.Random;

public class Engine {
    public static int getSpeed() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
