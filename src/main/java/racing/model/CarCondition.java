package racing.model;

import java.util.Random;

public class CarCondition {

    private static Random random = new Random();

    public static int get() {
        return random.nextInt(10);
    }
}
