package carracing.domain;

import java.util.Random;

public class RandomValue {

    private final int MAX_NUM = 10;

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }

}