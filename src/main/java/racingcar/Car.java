package racingcar;

import java.util.Random;

public class Car {

    private int countOfMove = 0;
    private Random random = new Random();

    public Car() {

    }

    public void move() {
        int numberOfRandom = random.nextInt(10);
        if (numberOfRandom >= 4) {
            countOfMove++;
        }
    }
}
