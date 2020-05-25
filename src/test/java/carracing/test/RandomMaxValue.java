package carracing.domain;

import java.util.Random;

public class RandomMaxValue extends RandomValue {

    private final int MAX_NUM = 3;

    @Override
    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
    }
}
