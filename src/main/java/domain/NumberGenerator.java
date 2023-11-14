package domain;

import java.util.Random;

public class NumberGenerator {

    private Random random;

    public NumberGenerator() {
    }

    public NumberGenerator(Random random) {
        this.random = random;
    }

    protected Integer moveCondition() {
        return random.nextInt(10);
    }


}
