package step5.view;

import step5.model.Car;

public class CarDTO {

    private int position;
    private String carName;

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public CarDTO(Car car) {
        this.position = car.getPosition().getPosition();
        this.carName = car.getCarName().getName();
    }
}
