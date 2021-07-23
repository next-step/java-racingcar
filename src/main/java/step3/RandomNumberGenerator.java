package step3;

import java.util.Random;

public class RandomNumberGenerator {
    static public int getRandomInt() {
        return new Random().nextInt(10);
    }
}
