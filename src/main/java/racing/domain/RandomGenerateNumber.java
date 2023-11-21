package racing.domain;

import java.util.Random;

public class RandomGenerateNumber implements GenerateNumber{

    public static final int MAX_RANDOM_NUMBER = 10;

    @Override
    public int getRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }
}
