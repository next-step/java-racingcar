package racingcar.dto;

import racingcar.domain.Car;

public class CarResultDto {
    public String name;
    public int position;

    public CarResultDto(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }
}
