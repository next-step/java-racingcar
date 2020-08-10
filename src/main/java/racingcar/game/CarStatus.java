package racingcar.game;

import racingcar.car.Car;

public class CarStatus {
    private String carName;
    private int position;

    private CarStatus(Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    public static CarStatus newInstance(Car car) {
        return new CarStatus(car);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
