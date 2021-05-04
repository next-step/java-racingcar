package racing.service;

import racing.domain.Car;

public class CarDto {
    private String carName;

    private int distance;

    private CarDto(Car car) {
        this.carName = car.carName();
        this.distance = car.distance();
    }

    public static CarDto of(Car car) {
        return new CarDto(car);
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
