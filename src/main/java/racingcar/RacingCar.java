package racingcar;

import java.util.Random;

public class RacingCar {
    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public boolean move(int randomNumber) {
        return randomNumber >= 4;
    }
}
