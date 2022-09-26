package racing.rule;

import java.util.concurrent.ThreadLocalRandom;

public class RandomRule implements Rule {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    public static final int MAX_NUMBER = 10;
    public static final int MOVABLE_NUMBER = 4;


    public boolean move() {
        return random.nextInt(MAX_NUMBER) >= MOVABLE_NUMBER;
    }

}
