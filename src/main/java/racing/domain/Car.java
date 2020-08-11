package racing.domain;

import racing.util.RandomUtil;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void run() {
        if (isCondition(RandomUtil.getRandomNum())) {
            move();
        }
    }

    public boolean isCondition(int randomNum) {
        return Condition.checkMove(randomNum);
    }

    void move() {
        this.location++;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
