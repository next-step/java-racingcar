package step3;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int randomIntBound = 10;

    private static RandomNumberGenerator randomNumberGenerator = null;

    private Random random;

    private RandomNumberGenerator() {
        this.random = new Random();
    }

    public static RandomNumberGenerator getRandomNumberGenerator(){
        if (randomNumberGenerator == null) {
            randomNumberGenerator = new RandomNumberGenerator();
        }

        return randomNumberGenerator;
    }

    public int getRandomInt() {
        return random.nextInt(randomIntBound);
    }
}
