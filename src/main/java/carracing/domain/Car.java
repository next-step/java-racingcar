package carracing.domain;

import java.util.Random;

public class Car {
    private static final int MOVABLE_NUMBER = 4;

    private static int carId;

    private int position;
    private boolean movable;

    public Car(final int carId,int position) {
        this.carId = carId;
        this.position = position;
    }

    public Car(final int carId) {
        this(carId, 0);
    }

    public int getPosition() {
        return this.position;
    }

    public void setMovable(int randomNumber){
        this.movable = randomNumber>MOVABLE_NUMBER;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", movable=" + movable +
                '}';
    }

    public void move() {
        if(this.movable) {
            this.position++;
        }
    }
}
