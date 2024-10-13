package racinggame.dto;

import java.util.Objects;
import racinggame.domain.Car;

public class CarDto {

    private final int position;
    private final String name;

    public CarDto(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public CarDto(Car car) {
        this(car.position(), car.name());
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDto carDto = (CarDto) o;
        return position == carDto.position && Objects.equals(name, carDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    public String name() {
        return name;
    }
}
