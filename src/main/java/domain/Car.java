package domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    private int position;
    private CarDisplacement carDisplacement;

    public Car(int position) {
        this.position = position;
    }

    public Car(Car car) {
        this.position = car.position;
        this.carDisplacement = car.carDisplacement;
    }

    private Car(CarState carState, CarDisplacement carDisplacement) {
        this.position = carState.position();
        this.carDisplacement = carDisplacement;
    }

    public static Car createCar(CarState carState, CarDisplacement carDisplacement) {
        return new Car(carState, carDisplacement);
    }

    public static Car createCopy(Car car) {
        return new Car(car);
    }

    public void move() {
        position += carDisplacement.move();
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

    public CarDisplacement getCarDisplacement() {
        return carDisplacement;
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
        return String.format("{position : %d}", position);
    }
}
