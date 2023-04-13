package study.step3;

import java.util.Random;

public class Car {

    public Car() {
    }

    public int getRandomInt() throws IllegalArgumentException {
        Random random = new Random();
        return random.nextInt(10);
    }
}
