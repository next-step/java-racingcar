package step3;

import java.util.Random;

public class RandomNumber {
    public static final int BOUND = 10;
    int num;

    public RandomNumber() {
        this.num = new Random().nextInt(BOUND);
    }
}
