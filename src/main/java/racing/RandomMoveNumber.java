package racing;

import java.util.Random;

public class RandomValue {
    public static int generate() {
        return new Random().nextInt(10);
    }
}
