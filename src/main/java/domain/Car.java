package domain;

import java.util.Random;

public class Car {

    private final int BASE_POINT = 4;

    private int position;
    private String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveForward(int randomCount) {
        if (randomCount >= BASE_POINT) {
            this.position++;
        }
    }

}
