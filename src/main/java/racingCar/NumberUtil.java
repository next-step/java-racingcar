package racingCar;

import java.util.Random;

public class NumberUtil {
    private Random random;

    public NumberUtil() {
        this.random = new Random();
    }
    public NumberUtil(Random random) {
        this.random = random;
    }
    public int getRandomInt() {
        return this.random.nextInt(10);
    }
}
