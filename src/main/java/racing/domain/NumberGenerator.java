package racing.domain;

import java.util.Random;

public class RandomNumber {
    public static int generator() {
        return new Random().nextInt(10);
    }
}
