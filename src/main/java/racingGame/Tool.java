package racingGame;

import java.util.Random;

public class Tool {

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
