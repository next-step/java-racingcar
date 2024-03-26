package RacingCar;

import RacingGame.Domain.RandomNumberStrategy;

import java.util.Random;

public class BigNumberStrategy implements RandomNumberStrategy {
    @Override
    public int generateRandomNumber() {
        return 5;
    }
}
