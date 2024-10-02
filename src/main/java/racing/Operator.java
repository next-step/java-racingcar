package racing;

import java.util.Random;

public class Operator {

    private Random random;

    public Operator() {
        this.random = new Random();
    }

    public Operator(Long seed) {
        this.random = new Random(seed);
    }

    public boolean isOngoing() {
        return this.random.nextInt(10) >= 4;
    }
}
