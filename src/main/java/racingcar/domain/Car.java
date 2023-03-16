package racingcar.domain;

import java.util.Random;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        Random random = new Random();
        final int randomNumber = getRandom();
        move(randomNumber);
    }

    protected int getRandom() {
        return new Random().nextInt(10);
    }

    public void move(final int randomnumber) {
        if (randomnumber > 4) {
            position++;
        }
    }

}
