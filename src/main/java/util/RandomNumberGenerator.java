package util;

import java.util.Random;

public class RandomNumberGenerator {
    private Random random = new Random();

    public int nextInt(int startNumber, int endNumber){
        return random.nextInt(endNumber - startNumber + 1) + startNumber;
    }
}
