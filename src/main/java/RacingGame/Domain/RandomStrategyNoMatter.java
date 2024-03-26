package RacingGame.Domain;

import java.util.Random;

public class RandomStrategyNoMatter implements RandomNumberStrategy {
    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
