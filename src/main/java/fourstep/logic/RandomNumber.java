package fourstep.logic;

import java.util.Random;

public class RandomNumber {

    private Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(9);
    }
}
