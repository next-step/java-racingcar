package RacingCar;

import RacingGame.Domain.RandomNumberStrategy;

import java.util.Random;

public class SmallNumberStrategy implements RandomNumberStrategy {
    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(4);
    }
}
