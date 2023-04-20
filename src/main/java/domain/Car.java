package domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public Car(Car car) {
        this.position = car.position;
    }

    private Car(CarState carState, CarLogic carLogic) {

    }

    public static Car createCar(CarState carState, CarLogic carLogic) {
        return new Car(carState, carLogic);
    }

    public void move(int nextInt) {
        position += nextInt;
    }

    public void randomMove() {
        move(canMove() ? Position.MOVE.getPosition() : Position.STOP.getPosition());
    }

    private boolean canMove() {
        Random ran = new Random();
        return ran.nextInt(RANDOM_RANGE) >= RANDOM_DIVIDING_POINT;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return this.position == car.position;
    }

    @Override
    public String toString() {
        return String.format("{location : %d}", position);
    }
}
