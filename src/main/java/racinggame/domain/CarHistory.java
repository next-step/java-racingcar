package racinggame.domain;

import racinggame.domain.car.Car;

public class CarHistory {

    private final String carName;
    private final Integer location;

    public CarHistory(Car car) {
        carName = car.getCarName();
        location = car.getLocation();
    }

    public String getCarName() {
        return carName;
    }

    public Integer getLocation() {
        return location;
    }
}
