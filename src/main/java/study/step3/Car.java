package study.step3;

import java.util.Random;

public class Car {

    private int position;

    public Car() {
        position = 0;
    }

    public int getPosition() {
        return position;
    }

    boolean move() {
        if (isExceedStandard(getRandomInt())) {
            position++;
            return true;
        }
        return false;
    }

    boolean isExceedStandard(int num) {
        return num > 3;
    }

    public int getRandomInt() throws IllegalArgumentException {
        Random random = new Random();
        return random.nextInt(10);
    }
}
