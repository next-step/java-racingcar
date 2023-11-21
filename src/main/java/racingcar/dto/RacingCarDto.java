package racingcar.dto;

import java.util.Objects;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarDto {

    private final String carName;
    private final long position;

    public RacingCarDto(String carName, long position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public long getPosition() {
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
        RacingCarDto that = (RacingCarDto) o;
        return position == that.position && Objects.equals(carName, that.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
