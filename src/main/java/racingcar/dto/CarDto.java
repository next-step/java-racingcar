package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {

    private String name;
    private int position;

    private CarDto(Car car) {
        this.name = car.getName().getValue();
        this.position = car.getPosition();
    }

    public static CarDto from(Car car) {
        return new CarDto(car);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
