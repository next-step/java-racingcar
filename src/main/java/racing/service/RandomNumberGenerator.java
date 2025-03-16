package racing.service;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generateRandomNumber(int rand) {
        return new Random().nextInt(rand);
    }
}
