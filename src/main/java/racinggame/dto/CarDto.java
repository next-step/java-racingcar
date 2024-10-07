package racinggame.dto;

import java.util.Objects;
import racinggame.domain.Car;

public class CarDto {

    private final int position;

    public CarDto(int position) {
        this.position = position;
    }

    public CarDto(Car car) {
        this(car.position());
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
        return position == carDto.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
