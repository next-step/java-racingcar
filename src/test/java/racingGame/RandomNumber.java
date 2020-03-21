package racingGame;

import java.util.Random;

public class RandomNumber {

    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
