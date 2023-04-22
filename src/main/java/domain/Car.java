package domain;

import java.util.Random;

public class Car {
    private static final int RANDOM_RANGE = 10;
    private static final int RANDOM_DIVIDING_POINT = 4;

    private int position;
    private final CarDisplacement carDisplacement;

    private Car(Car car) {
        this.position = car.getPosition();
        this.carDisplacement = car.getCarDisplacement();
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
        position += carDisplacement.displacement();
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
