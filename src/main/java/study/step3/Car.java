package study.step3;

import java.util.Random;

public class Car {

    private int round;
    private int position;

    public Car() {
        round = 0;
        position = 0;
    }

    public boolean move() {
        round++;
        if (isExceedStandard(getRandomInt())) {
            position++;
            return true;
        }

        return false;
    }

    public boolean isExceedStandard(int num) {
        return num > 3;
    }

    public int getRandomInt() throws IllegalArgumentException {
        Random random = new Random();
        return random.nextInt(10);
    }
}
