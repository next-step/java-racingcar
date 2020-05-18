package racing;

import java.util.Random;

public class Dice {
    public static int cast() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
