package study.step_3;

import java.util.Random;

public class RandomNumber {
    private int value;

    public int generate() {
        Random random = new Random();
        this.value = random.nextInt(10);

        return this.value;
    }
}
