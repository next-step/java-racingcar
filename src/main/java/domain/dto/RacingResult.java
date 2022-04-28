package domain.dto;

import domain.Car;

import java.util.Objects;

public class RacingResult {
    private final String carName;
    private final int position;

    private RacingResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static RacingResult from(Car car) {
        return new RacingResult(car.getName(), car.getPosition());
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
        RacingResult carDto = (RacingResult) o;
        return position == carDto.position && Objects.equals(carName, carDto.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
