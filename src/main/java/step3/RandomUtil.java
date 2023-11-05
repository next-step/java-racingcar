package step3;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    private int bound;

    public RandomUtil(int bound) {
        this.bound = bound;
    }

    public int random() {
        return random.nextInt(bound);
    }

}
