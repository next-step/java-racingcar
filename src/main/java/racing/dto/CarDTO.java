package racing.dto;

import racing.domain.Car;

public class CarDTO {

    private String name;
    private int position;

    public CarDTO(Car car) {
        this.name = car.getName();
        this.position = car.getNowPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
