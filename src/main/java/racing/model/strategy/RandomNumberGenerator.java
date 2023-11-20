package racing.model.strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGeneratorStrategy{

    Random random = new Random();

    @Override
    public int generateNumber(int number) {
        return random.nextInt(number);
    }
}
