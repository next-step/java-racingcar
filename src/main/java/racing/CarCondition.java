package racing;

import java.util.Random;

public class CarCondition {

    static Random random = new Random();

    public static int get() {
        return random.nextInt(10);
    }
}
