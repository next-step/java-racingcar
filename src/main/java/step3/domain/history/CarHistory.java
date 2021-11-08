package step3.domain.history;

import step3.domain.Car;

public class CarHistory {
    private Car car;
    private int position;

    private CarHistory() {}

    public CarHistory(Car car) {
        this.car = car;
        this.position = car.getPosition();
    }

    public Car getCar() {
        return car;
    }

    public int getPosition() {
        return position;
    }
}
