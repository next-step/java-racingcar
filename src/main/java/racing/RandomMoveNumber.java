package racing;

import java.util.Random;

public class RandomMoveNumber {
    public static int generate() {
        return new Random().nextInt(10);
    }
}
