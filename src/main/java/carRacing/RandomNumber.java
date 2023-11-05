package carRacing;

import java.util.Random;

public class RandomNumber {

    private static final Random RANDOM = new Random();
    private static final int MAX = 10;

    private RandomNumber(){

    }

    public static int generate() {
        return RANDOM.nextInt(MAX);
    }
}
