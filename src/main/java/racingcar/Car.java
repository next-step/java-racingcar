package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int index;

    private final Random random;

    public Car(String name, int index, Random random) {
        this.name = name;
        this.index = index;
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
