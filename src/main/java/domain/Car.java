package domain;

import java.util.Random;

public class Car {

    private int position;

    public Car() {
        this(0);
    }
    public Car(int position) {
        this.position = position;
    }

    public int move() {
        return position + 1;
    }
}
