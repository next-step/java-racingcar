package racingcargame.model;

import java.util.Random;

public class RandomNumber {
<<<<<<< HEAD
    private Random random = new Random();

    public int getNumber() {
        return random.nextInt(10);
=======
    private static final int EXCEED_NUMBER = 10;
    private static final Random random = new Random();

    public static int createRandomNumber() {
        return random.nextInt(EXCEED_NUMBER);
>>>>>>> origin/step2
    }
}
