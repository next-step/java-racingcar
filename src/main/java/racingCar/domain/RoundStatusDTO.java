package racingCar.domain;

import java.util.Objects;

public class RoundStatusDTO {
    private final String carName;
    private final int position;

    public static RoundStatusDTO of(Car car) {
        return new RoundStatusDTO(car.getCarName(), car.getPosition());
    }
    public RoundStatusDTO(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundStatusDTO that = (RoundStatusDTO) o;
        return position == that.position && Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
