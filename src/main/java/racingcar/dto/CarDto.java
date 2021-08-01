package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
    private String name;

    private int position;

    public CarDto(Car car) {
        this.name = car.getName().getName();
        this.position = car.getPosition().getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
