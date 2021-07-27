package study;

import java.util.Random;

public class RacingManager {

    public boolean canMoveCar(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
