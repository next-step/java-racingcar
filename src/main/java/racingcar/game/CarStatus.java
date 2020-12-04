package racingcar.game;

import racingcar.car.Car;

public class CarStatus {
    private String carName;
    private int position;

    private CarStatus(Car car) {
        this.carName = car.getName();
        this.position = car.getPosition();
    }

    private CarStatus(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarStatus newInstance(Car car) {
        return new CarStatus(car);
    }

    public static CarStatus newInstance(String carName, int position) {
        return new CarStatus(carName, position);
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public boolean equalsPosition(int position) {
        return this.position == position;
    }
}
