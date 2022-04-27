package domain.dto;

import domain.Car;

import java.util.Objects;

public class CarDto {
    private final String carName;
    private final int position;

    private CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
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
        return position == carDto.position && Objects.equals(carName, carDto.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
