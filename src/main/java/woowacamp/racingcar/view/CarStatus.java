package woowacamp.racingcar.view;

import woowacamp.racingcar.domain.Car;

public class CarStatus {
    private final String name;

    private final int position;

    public CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarStatus from(Car car) {
        return new CarStatus(car.getName().getValue(), car.getPosition().getValue());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
