package racing.domain;

import java.util.Random;

public class Car {
    static final int RANDOM_MAX_NUM = 10;
    int location;

    Car() {
        this.location = 0;
    }

    public void run() {
        if (isCondition(getRandomNum())) {
            move();
        }
    }

    public int getRandomNum() {
        return new Random().nextInt(RANDOM_MAX_NUM);
    }

    public boolean isCondition(int randomNum) {
        return Condition.checkMove(randomNum);
    }

    public void move() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }
}
