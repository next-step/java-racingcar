package CarRacing;

import java.util.Random;

public class RandomMinValue extends RandomValue {

    private final int MIN_NUM = 5;

    @Override
    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(MIN_NUM) + MIN_NUM;
    }
}
