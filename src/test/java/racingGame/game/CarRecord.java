package racingGame.game;

import racingGame.car.Car;

public class CarRecord {
    private Car car;
    private int distance;

    public CarRecord(Car car) {
        this.car = car;
        this.distance = car.getPosition();
    }

    public Car getCar() {
        return car;
    }

    public int getDistance() {
        return distance;
    }
}
