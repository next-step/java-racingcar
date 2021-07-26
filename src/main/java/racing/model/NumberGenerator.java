package racing.model;

import java.util.Random;

public class NumberGenerator {
    private static final Random random = new Random();

    static Number getNewRandomNumber() {
        return new Number(random.nextInt(10));
    }
}
