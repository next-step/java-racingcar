package racingCar;

import java.util.Random;

class RandomNumberGenerator{
    final int RANDOM_NUMBER_BOUND = 10;
    public int makeRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_BOUND);
    }
}
