package racingcar.game.dto;

import racingcar.car.Car;

public class CarDto {
    private final int location;
    private final String name;

    public CarDto(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public CarDto(Car car) {
        this(car.location().getLocation(), car.name().getName());
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDto)) return false;

        CarDto carDto = (CarDto) o;

        if (location != carDto.location) return false;
        return name != null ? name.equals(carDto.name) : carDto.name == null;
    }

    @Override
    public int hashCode() {
        int result = location;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
