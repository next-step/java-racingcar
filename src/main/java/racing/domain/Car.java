package racing.domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_MAX_NUM = 10;
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void run() {
        if (isCondition(getRandomNum())) {
            move();
        }
    }

    private int getRandomNum() {
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

    public String getName() {
        return name;
    }
}
