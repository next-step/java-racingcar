package test;

import java.util.Random;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    protected int getRandNum() {
        Random rd = new Random();
        return rd.nextInt(10);
    }
}
