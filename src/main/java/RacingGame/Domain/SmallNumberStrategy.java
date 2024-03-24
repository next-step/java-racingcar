package RacingGame.Domain;

import java.util.Random;

public class SmallNumberStrategy implements RandomNumberStrategy {
    @Override
    public int GenerateRandomNumber() {
        Random random = new Random();
        return random.nextInt(4);
    }
}
