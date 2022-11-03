package racingGame.dto;

import racingGame.domain.Car;
import racingGame.domain.Cars;

public class CarDto {

    private String name;
    private int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition(){
        return position;
    }
}
