package step5.domain;

import java.util.Random;

public class RandomGeneratePolicy implements MovingPolicy {

    private final static int RANDOM_NUM = 10;
    Random random = new Random();
    @Override
    public int generateRandom() {
        return random.nextInt(RANDOM_NUM);
    }
}
