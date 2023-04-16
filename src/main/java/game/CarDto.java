package game;

import car.Car;

public class CarDto {
    private final String name;
    private final int position;

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName().toString(), car.getPosition().intValue());
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
