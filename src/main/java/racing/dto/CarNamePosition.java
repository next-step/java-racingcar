package racing.dto;

import racing.model.Car;

public class CarNamePosition {

    private String carName;
    private int position;

    private CarNamePosition() {}

    public static CarNamePosition of (Car car) {

        CarNamePosition carNamePosition = new CarNamePosition();
        carNamePosition.carName = car.getName();
        carNamePosition.position = car.getPosition();
        return carNamePosition;
    }

    public String getCarName() {

        return carName;
    }

    public int getPosition() {

        return position;
    }
}
