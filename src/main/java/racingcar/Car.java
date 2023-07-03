package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int index;

    private final Random random;

    public Car(String name) {
        this.name = name;
        this.index = 1;
        this.random = new Random();
    }

    public Car(String name, Random random) {
        this.name = name;
        this.index = 1;
        this.random = random;
    }

    public void move() {
        if (isMove(random.nextInt(10))) {
            index++;
        }
    }

    public boolean isMove(int value) {
        return value >= 4;
    }

    public int getIndex() {
        return index;
    }
}
