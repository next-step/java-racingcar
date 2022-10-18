package fourstep.logic;

import java.util.Random;

public class RandomNumber {

    private final Random random = new Random();
    public int getRandomNumber() {
        return random.nextInt(9);
    }
}
